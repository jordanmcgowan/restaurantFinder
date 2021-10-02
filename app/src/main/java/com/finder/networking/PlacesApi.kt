package com.finder.networking

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface PlacesApi {
    @GET("nearbysearch/json?radius=1500&type=restaurant&key=AIzaSyDQSd210wKX_7cz9MELkxhaEOUhFP0AkSk")
    fun fetchRestaurantSuggestionsBasedOnLocation(
        @Query("keyword") keyword: String? = null,
        @Query("location") location: String? = null
    ): Call<RestaurantSuggestionResponse>
}