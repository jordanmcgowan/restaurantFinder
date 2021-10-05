package com.finder.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finder.MyApp
import com.finder.networking.PlacesManager
import com.finder.Suggestion
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel : ViewModel() {

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

  // TODO - pipe through the network failures?
  object Error : DetailState()
}