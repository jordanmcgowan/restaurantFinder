package com.finder.networking

import com.finder.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlacesApi {
    @GET("nearbysearch/json?radius=5000&type=restaurant")
    fun fetchRestaurantSuggestionsBasedOnLocation(
        @Query("keyword") keyword: String? = null,
        @Query("location") location: String? = null,
        @Query("key") key: String? = BuildConfig.apiKey
    ): Call<RestaurantSuggestionResponse>

    @GET("details/json")
    fun fetchRestaurantSuggestionDetails(
        @Query("place_id") suggestionId: String? = null,
        @Query("key") key: String? = BuildConfig.apiKey
    ): Call<RestaurantSuggestionDetailResponse>


}