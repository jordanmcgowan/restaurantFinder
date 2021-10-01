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
                // Handle empty list?
                val suggestions = response.body()?.results?.map {
                    Suggestion(
                        name = it.name
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
    val name: String
)