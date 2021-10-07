package com.finder.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finder.MyApp
import com.finder.Suggestion
import com.finder.networking.DetailsResponse
import com.finder.networking.PlacesManager
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel : ViewModel() {

  @set:Inject
  lateinit var placesManager: PlacesManager

  init {
    MyApp.placesComponent.inject(this)
  }

  private val state = BehaviorSubject.create<DetailState>()
  fun state(): Observable<DetailState> = state.hide()

  fun getSuggestionDetails(
    suggestionId: String
  ): LiveData<DetailsResponse> {
    state.onNext(DetailState.Loading)
    return placesManager.fetchSuggestionDetails(
      suggestionId = suggestionId
    )
  }

  fun updateFavoriteState(suggestion: Suggestion) {
    viewModelScope.launch {
      placesManager.insertOrOverrideSuggestionState(suggestion = suggestion)
    }
  }

  // FUTURE IMPROVEMENT - This placeId class should be strongly typed to prevent random strings from being passed in
  fun getSuggestionFromPlaceId(placeId: String): LiveData<Suggestion> {
    return placesManager.getSuggestionFromPlaceId(placeId = placeId)
  }
}

sealed class DetailState {
  object Loading : DetailState()
  data class Content(
    val suggestion: Suggestion
  ) : DetailState()
  data class Error(
    val message: String
  ): DetailState()
}