package com.finder

import com.finder.networking.*
import com.finder.storage.SuggestionRepository
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import strikt.api.expectThat

class PlacesManagerTest {

  private val response =
    Response.success(
      RestaurantSuggestionDetailResponse(
        result = RestaurantResultResponse(
          name = "Jordan's Jam"
        )
      )
    )

//  private val mockCall = mock<Call<RestaurantSuggestionDetailResponse>> {
//    on { enqueue(any()) } doReturn { response }
//  }

  private val placesApi = mock<PlacesApi> {
//    on { fetchRestaurantSuggestionDetails(suggestionId = any(), key = any()) } doReturn mockCall
  }

  private val mockSuggestionsRepository = mock(SuggestionRepository::class.java)

  val placesManager = PlacesManager(
    placesApi = placesApi,
    suggestionRepository = mockSuggestionsRepository
  )

  @Test
  fun `it should GET with query`() {

    val remoteApi = remoteApi(baseUrl = "http://some.api")

    val givenSearchQuery = "given search phrase"

    val call: Call<RestaurantSuggestionDetailResponse> = remoteApi.fetchRestaurantSuggestionDetails(suggestionId = givenSearchQuery)

    expectThat(call.request()) {
      assertThat("is GET method") {
        it.method == "GET"
      }
      assertThat("has given search query") {
        it.url.queryParameterValues("search") == listOf(givenSearchQuery)
      }
    }
  }

  fun remoteApi(baseUrl: String): PlacesApi {
    return Retrofit.Builder()
      .client(OkHttpClient())
      .baseUrl(baseUrl)
      .build()
      .create(PlacesApi::class.java)
  }


}