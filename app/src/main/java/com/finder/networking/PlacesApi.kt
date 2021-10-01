package com.finder.networking

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.converter.moshi.MoshiConverterFactory

interface PlacesApi {
    @GET("nearbysearch/json?location=-33.8670522%2C151.1957362&radius=1500&type=restaurant&key=AIzaSyDQSd210wKX_7cz9MELkxhaEOUhFP0AkSk")
    fun fetchRestaurantSuggestionsBasedOnLocation(
        @Query("keyword") keyword: String? = null
    ): Call<RestaurantSuggestionResponse>
}