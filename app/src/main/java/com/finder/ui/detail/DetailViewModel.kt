package com.finder.ui.detail

import androidx.lifecycle.ViewModel
import com.finder.MyApp
import com.finder.networking.PlacesManager
import com.finder.networking.Suggestion
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class DetailViewModel: ViewModel() {

    @set:Inject
    lateinit var placesManager: PlacesManager

    init {
        MyApp.placesComponent.inject(this)
    }

    private val compositeDisposable = CompositeDisposable()

    private val state = BehaviorSubject.create<DetailState>()
    fun state(): Observable<DetailState> = state.hide()

    // This method should be called on App Launch based on current location
    fun getSuggestionDetails(
        suggestionId: String? = null
    ) {
        state.onNext(DetailState.Loading)

        if (suggestionId == null) {
            // This should save issues with an arguments key mismatch should it happen
            state.onNext(DetailState.Error)
        } else {
            compositeDisposable.add(
                placesManager.fetchSuggestionDetails(
                    suggestionId = suggestionId
                ).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        state.onNext(DetailState.Content(it))
                    }
            )
        }

    }
}

sealed class DetailState {
    object Loading: DetailState()
    data class Content(
        val suggestion: Suggestion
    ): DetailState()
    // TODO - pipe through the network failures?
    object Error: DetailState()
}