package com.finder.ui.main

import androidx.lifecycle.ViewModel
import com.finder.MyApp
import com.finder.networking.PlacesApi
import com.finder.networking.PlacesManager
import com.finder.networking.Suggestion
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class MainViewModel : ViewModel() {

    @set:Inject
    lateinit var placesManager: PlacesManager

    init {
        MyApp.placesComponent.inject(this)
    }

    private val compositeDisposable = CompositeDisposable()

    private val state = BehaviorSubject.create<SuggestionState>()
    fun state(): Observable<SuggestionState> = state.hide()

    // This method should be called on App Launch based on current location
    fun getSuggestionsBasedOnLocation(
        lat: Double? = null,
        long: Double? = null
    ) {
        state.onNext(SuggestionState.Loading)

        compositeDisposable.add(
            placesManager.fetchGeneralRestaurantSuggestions(
                lat = lat,
                long = long
            ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it.isNotEmpty()) {
                        state.onNext(SuggestionState.Content(it))
                    } else {
                        state.onNext(SuggestionState.Empty)
                    }
                }
        )
    }
}

sealed class SuggestionState {
    object Loading: SuggestionState()
    data class Content(
        val suggestionList: List<Suggestion>
    ): SuggestionState()
    object Empty: SuggestionState()
    // TODO - pipe through the network failures?
    object Error: SuggestionState()
}

sealed class SuggestionAction {
    data class SeeSuggestionDetails(val suggestion: Suggestion): SuggestionAction()
}