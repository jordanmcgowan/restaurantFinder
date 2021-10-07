package com.finder

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Entity(tableName = "suggestions")
data class Suggestion(
  @PrimaryKey(autoGenerate = false)
  val placeId: String,
  val name: String,
  val imageReference: String? = null,
  val address: String? = null,
  val rating: Float? = null,
  val ratingCount: Int? = null,
  val priceLevel: Int? = null,
  // We'll give these location values a default as they're unused in the Suggestion List context,
  // only within Details
  val lat: Float? = null,
  val lng: Float? = null,
  val openNow: Boolean = false,
  val reviewText: String? = null,
  val isFavorite: Boolean = false
) : Serializable


// A slimmed down version of the original object that we can pass through Fragment bundles.
// The amount of data is small enough that we should overflow the Bundle's max size, but we can
// always be more careful. This will at least save us from making another network request.
// FUTURE IMPROVEMENT - We could store these values in the local DB and retrieve them once the
// MapFragment (the only current consumer) loads
@Parcelize
data class SuggestionLite(
  val placeId: String,
  val lat: Float?,
  val lng: Float?,
  val name: String,
  val address: String?,
  val isFavorite: Boolean
): Parcelable

fun Suggestion.toSuggestionLite(): SuggestionLite {
  return SuggestionLite(
    placeId = placeId,
    lat = lat,
    lng = lng,
    name = name,
    address = address,
    isFavorite = isFavorite
  )
}

fun SuggestionLite.toSuggestion(): Suggestion {
  return Suggestion(
    placeId = placeId,
    lat = lat,
    lng = lng,
    name = name
  )
}