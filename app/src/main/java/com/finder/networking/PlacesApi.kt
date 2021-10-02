package com.finder.networking

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface PlacesApi {
    @GET("nearbysearch/json?location=-33.8670522%2C151.1957362&radius=1500&type=restaurant&key=AIzaSyDQSd210wKX_7cz9MELkxhaEOUhFP0AkSk")
    fun fetchRestaurantSuggestionsBasedOnLocation(
        @Query("keyword") keyword: String? = null
    ): Call<RestaurantSuggestionResponse>
}