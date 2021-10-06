package com.finder

import com.finder.networking.*
import com.finder.storage.SuggestionRepository
import okhttp3.OkHttpClient
import org.junit.Test
import org.mockito.Mockito.*
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

    val mockApi = mockApi(baseUrl = "http://googleMock")

    val suggestionId = "place1"

    val call: Call<RestaurantSuggestionDetailResponse> = mockApi.fetchRestaurantSuggestionDetails(suggestionId = suggestionId)

    expectThat(call.request()) {
      assertThat("is GET request") {
        it.method == "GET"
      }
      assertThat("has suggestionId") {
        it.url.queryParameterValues("place_id") == listOf(suggestionId)
      }
    }
  }

  private fun mockApi(baseUrl: String): PlacesApi {
    return Retrofit.Builder()
      .client(OkHttpClient())
      .baseUrl(baseUrl)
      .build()
      .create(PlacesApi::class.java)
  }


}