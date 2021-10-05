package com.finder.networking

import androidx.lifecycle.LiveData
import com.finder.Suggestion
import com.finder.storage.SuggestionRepository
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class PlacesManager internal constructor(
  private val placesApi: PlacesApi,
  private val suggestionRepository: SuggestionRepository
) {


  fun fetchGeneralRestaurantSuggestions(
    lat: Double?,
    long: Double?,
    // Only will be used when coming from the Search flow, not for base suggestions
    keyword: String?
  ): Observable<List<Suggestion>> {
    return Observable.create { subscriber ->
      // Query requires a comma sep lat, long. We can construct that here
      val locationString = "${lat},${long}"

      val response =
        placesApi.fetchRestaurantSuggestionsBasedOnLocation(
          location = locationString,
          keyword = keyword
        ).execute()

      if (response.isSuccessful) {

        // TODO - Handle empty list?
        /**
         * Suggestions without:
         *  - names will be filtered out since they won't be meaningful to the user
         *  - placeIds will be filtered out since it's the query key in the DB and must be
         *  present for DB operations
         */
        val suggestions =
          response.body()?.results?.filter { it.name != null && it.placeId != null }
            ?.map {
              transformSuggestionResponse(suggestionResponse = it)
            } ?: emptyList()

        subscriber.onNext(suggestions)
        // TODO - necessary?
        subscriber.onComplete()

      } else {
        subscriber.onError(Throwable(response.message()))
      }

    }
  }

  fun fetchSuggestionDetails(
    suggestionId: String
  ): Observable<Suggestion> {
    return Observable.create { subscriber ->

      val response =
        placesApi.fetchRestaurantSuggestionDetails(suggestionId = suggestionId)
          .execute()

      val result = response.body()?.result
      /**
       * A response without a:
       *  - name will be considered invalid since it won't be meaningful to the user
       *  - placeId will be considered invalid since it's the query key in the DB and must
       *  be present for DB operations
       */
      if (response.isSuccessful && result != null && result.name != null && result.placeId != null) {
        val suggestion = response.body()?.result?.let {
          transformSuggestionResponse(suggestionResponse = it)
        }

        subscriber.onNext(suggestion)
        // TODO - necessary?
        subscriber.onComplete()

      } else {
        subscriber.onError(Throwable(response.message()))
      }

    }
  }

  fun getCachedSuggestions(): LiveData<List<Suggestion>> {
    return suggestionRepository.getCachedSuggestions()
  }

  fun getSuggestionFromPlaceId(placeId: String): LiveData<Suggestion> {
    return suggestionRepository.getSuggestionFromPlaceId(placeId = placeId)
  }

  suspend fun insertOrOverrideSuggestionState(suggestion: Suggestion) {
    suggestionRepository.storeSuggestionInDB(suggestion)
  }

  private fun transformSuggestionResponse(suggestionResponse: RestaurantResultResponse): Suggestion {
    return Suggestion(
      name = suggestionResponse.name!!,
      placeId = suggestionResponse.placeId!!,
      address = suggestionResponse.formattedAddress,
      rating = suggestionResponse.rating,
      // Trust the first image is the best -- the API doesn't provide a better
      // option
      imageReference = suggestionResponse.photos?.get(0)?.reference,
      ratingCount = suggestionResponse.ratingCount,
      priceLevel = suggestionResponse.priceLevel,
      lat = suggestionResponse.geometry?.location?.latitude,
      lng = suggestionResponse.geometry?.location?.longitude,
      // TODO
      isFavorite = false
    )
  }
}

