package com.finder

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "suggestions")
data class Suggestion(
  @PrimaryKey(autoGenerate = false)
  val placeId: String,
  val name: String,
  val imageReference: String?,
  val address: String?,
  val rating: Float?,
  val ratingCount: Int?,
  val priceLevel: Int?,
  // We'll give these a default as they're unused in the Suggestion List context, only within
  // Details
  val lat: Float? = null,
  val lng: Float? = null,
  val isFavorite: Boolean = false
) : Serializable