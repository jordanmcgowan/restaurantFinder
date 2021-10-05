package com.finder.networking

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.finder.Suggestion
import com.finder.storage.SuggestionRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlacesManager internal constructor(
  private val placesApi: PlacesApi,
  private val suggestionRepository: SuggestionRepository
) {


  fun fetchGeneralRestaurantSuggestions(
    lat: Double?,
    long: Double?,
    // Only will be used when coming from the Search flow, not for base suggestions
    keyword: String?
  ): LiveData<SearchResponse> {

    val liveData = MutableLiveData<SearchResponse>()
    // Query requires a comma sep lat, long. We can construct that here
    val locationString = "${lat},${long}"
    placesApi.fetchRestaurantSuggestionsBasedOnLocation(
      location = locationString,
      keyword = keyword
    ).enqueue(object : Callback<RestaurantSuggestionResponse> {
      override fun onResponse(
        call: Call<RestaurantSuggestionResponse>,
        response: Response<RestaurantSuggestionResponse>
      ) {
        if (response.isSuccessful) {
          val result = response.body()?.results
          /**
           * A response without a:
           *  - name will be considered invalid since it won't be meaningful to the user
           *  - placeId will be considered invalid since it's the query key in the DB and must
           *  be present for DB operations
           */
          if (result != null) {
            liveData.value = SearchResponse.Success(
             data = result.filter { it.name != null && it.placeId != null }
               .map {
                 transformSuggestionResponse(suggestionResponse = it)
               }
            )
          }
        }
      }

      override fun onFailure(call: Call<RestaurantSuggestionResponse>, t: Throwable) {
        t.printStackTrace()
        // FUTURE IMPROVEMENT - Update this to handle particular errors/HTTP codes instead of
        // blanket error messaging
        liveData.value = SearchResponse.Error(
          error = t
        )
      }
    })
    return liveData
  }

  fun fetchSuggestionDetails(
    suggestionId: String
  ): LiveData<DetailsResponse> {
    val liveData = MutableLiveData<DetailsResponse>()

    placesApi.fetchRestaurantSuggestionDetails(suggestionId = suggestionId)
      .enqueue(object : Callback<RestaurantSuggestionDetailResponse> {
        override fun onResponse(
          call: Call<RestaurantSuggestionDetailResponse>,
          response: Response<RestaurantSuggestionDetailResponse>
        ) {
          if (response.isSuccessful) {
            val result = response.body()?.result
            /**
             * A response without a:
             *  - name will be considered invalid since it won't be meaningful to the user
             *  - placeId will be considered invalid since it's the query key in the DB and must
             *  be present for DB operations
             */
            if (result?.name != null && result.placeId != null) {
              liveData.value = DetailsResponse.Success(transformSuggestionResponse(suggestionResponse = result))
            }
          }
        }

        override fun onFailure(call: Call<RestaurantSuggestionDetailResponse>, t: Throwable) {
          t.printStackTrace()
          liveData.value = DetailsResponse.Error(error = t)
        }
      })
    return liveData
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
      openNow = suggestionResponse.hoursResponse?.openNow ?: false
    )
  }
}