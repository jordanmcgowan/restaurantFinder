package com.finder.networking

import com.finder.MyApp
import io.reactivex.Observable
import javax.inject.Inject

class PlacesManager internal constructor(
    private val placesApi: PlacesApi
) {


    fun fetchGeneralRestaurantSuggestions(
        lat: Float?,
        long: Float?
    ): Observable<List<Suggestion>> {
        return Observable.create { subscriber ->
            val response = placesApi.fetchRestaurantSuggestionsBasedOnLocation().execute()

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