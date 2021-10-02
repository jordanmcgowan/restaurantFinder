package com.finder.networking

import com.finder.MyApp
import io.reactivex.Observable
import javax.inject.Inject

class PlacesManager internal constructor(
    private val placesApi: PlacesApi
) {


    fun fetchGeneralRestaurantSuggestions(
        lat: Double?,
        long: Double?
    ): Observable<List<Suggestion>> {
        return Observable.create { subscriber ->
            // Query requires a comma sep lat, long. We can construct that here
            val locationString = "${lat},${long}"

            val response =
                placesApi.fetchRestaurantSuggestionsBasedOnLocation(location = locationString)
                    .execute()

            if (response.isSuccessful) {
                // TODO - Handle empty list?
                // Suggestions without names will be filtered out since they won't be meaningful
                // to the user
                val suggestions = response.body()?.results?.filter { it.name != null }?.map {
                    Suggestion(
                        name = it.name!!,
                        address = it.formattedAddress,
                        rating = it.rating
                    )
                } ?: emptyList()

                subscriber.onNext(suggestions)
                // TODO - necessary?
                subscriber.onComplete()

            } else {
                subscriber.onError(Throwable(response.message()))
            }

        }
    }
}

// TODO - flush this out more
data class Suggestion(
    val name: String,
    val address: String?,
    val rating: Float?
)