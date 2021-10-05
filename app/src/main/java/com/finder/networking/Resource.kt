package com.finder.networking

import com.finder.Suggestion

// FUTURE IMPROVEMENT - Consolidate these classes and use a General type (T) that would be able to
// handle all requests
sealed class SearchResponse {
  data class Success(
    val data: List<Suggestion>
  ): SearchResponse()

  data class Error(
    val error: Throwable,
    val message: String = "An error occurred while fetching search results"
  ): SearchResponse()
}

sealed class DetailsResponse {
  data class Success(
    val data: Suggestion
  ): DetailsResponse()

  data class Error(
    val error: Throwable,
    val message: String = "An error occurred when trying to find that location"
  ): DetailsResponse()
}