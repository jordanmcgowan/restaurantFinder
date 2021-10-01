package com.finder.networking

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RestaurantSuggestionResponse(
    @Json(name = "results") val results: List<RestaurantResultResponse>
)

@JsonClass(generateAdapter = true)
data class RestaurantResultResponse(
    @Json(name = "formatted_address") val formattedAddress: String,
    @Json(name = "name") val name: String,
    @Json(name = "rating") val rating: Float,
    @Json(name = "opening_hours") val hours: RestaurantOpeningHours,
    @Json(name = "geometry") val geometry: RestaurantGeometryResponse
)

@JsonClass(generateAdapter = true)
data class RestaurantOpeningHours(
    @Json(name = "open_now") val openNow: Boolean
)

@JsonClass(generateAdapter = true)
data class RestaurantGeometryResponse(
    @Json(name = "location") val location: RestaurantLocationResponse
)

@JsonClass(generateAdapter = true)
data class RestaurantLocationResponse(
    @Json(name = "lat") val latitude: Float,
    @Json(name = "lng") val longitude: Float,
)