package com.finder.networking

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * Used ONLY for the Suggestions query -- the RestaurantResultResponse is shared, but this is for a
 * list of suggestions
 */
@JsonClass(generateAdapter = true)
data class RestaurantSuggestionResponse(
  @Json(name = "results") val results: List<RestaurantResultResponse>
)

/**
 * Used ONLY for the Details query -- the RestaurantResultResponse is shared, but this is for one
 * suggestion
 */
@JsonClass(generateAdapter = true)
data class RestaurantSuggestionDetailResponse(
  @Json(name = "result") val result: RestaurantResultResponse
)


@JsonClass(generateAdapter = true)
data class RestaurantResultResponse(
  // Name and PlaceId are optional response params but we require them in code. Forcing them to be
  // non-null here _could_ be an option. We could allow Moshi to fail to deserialize the result
  // and throw an error. However, since we're sharing a result between the List & Detail view,
  // doing that within the List context would result in the entire list error-ing out (which is
  // not ideal)
  @Json(name = "name") val name: String? = null,
  @Json(name = "place_id") val placeId: String? = null,
  @Json(name = "vicinity") val formattedAddress: String? = null,
  @Json(name = "geometry") val geometry: RestaurantGeometryResponse? = null,
  @Json(name = "opening_hours") val hoursResponse: RestaurantOpeningHoursResponse? = null,
  @Json(name = "rating") val rating: Float? = null,
  @Json(name = "user_ratings_total") val ratingCount: Int? = null,
  @Json(name = "price_level") val priceLevel: Int? = null,
  @Json(name = "photos") val photos: List<RestaurantPhotosResponse>? = null
)

@JsonClass(generateAdapter = true)
data class RestaurantOpeningHoursResponse(
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


@JsonClass(generateAdapter = true)
data class RestaurantPhotosResponse(
  @Json(name = "photo_reference") val reference: String
)
