package com.finder.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finder.MyApp
import com.finder.networking.PlacesManager
import com.finder.Suggestion
import com.finder.SuggestionLite
import com.finder.networking.SearchResponse
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel : ViewModel() {

    @set:Inject
    lateinit var placesManager: PlacesManager

    init {
        MyApp.placesComponent.inject(this)
    }

    private val state = BehaviorSubject.create<SuggestionState>()
    fun state(): Observable<SuggestionState> = state.hide()

    // This method should be called on App Launch based on current location (with a null keyword)
    // and after keyword searches (with a valid keyword)
    fun getSuggestions(
        lat: Double? = null,
        long: Double? = null,
        // This wil be present when the user has entered a search term. It will be null on app
        // launch when we get the base suggestions
        keyword: String? = null
    ): LiveData<SearchResponse> {
        state.onNext(SuggestionState.Loading)
        return placesManager.fetchGeneralRestaurantSuggestions(
            lat = lat,
            long = long,
            keyword = keyword
        )
    }

    fun updateFavoriteState(suggestion: Suggestion) {
        viewModelScope.launch {
            placesManager.insertOrOverrideSuggestionState(suggestion = suggestion)
        }
    }

    fun getCachedSuggestions(): LiveData<List<Suggestion>> {
        return placesManager.getCachedSuggestions()
    }
}

sealed class SuggestionState {
    object Loading: SuggestionState()
    data class Content(
        val suggestionList: List<Suggestion>
    ): SuggestionState()
    object Empty: SuggestionState()
    data class Error(
        val message: String
    ): SuggestionState()
}

sealed class SuggestionAction {
    data class SeeSuggestionDetails(val suggestion: Suggestion): SuggestionAction()
    data class UpdateFavoriteState(val suggestion: Suggestion): SuggestionAction()
    data class SeeSuggestionsOnMap(val suggestionList: List<SuggestionLite>) : SuggestionAction()
}