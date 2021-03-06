package com.finder.di

import android.content.Context
import androidx.room.Room
import com.finder.networking.PlacesApi
import com.finder.networking.PlacesManager
import com.finder.storage.SuggestionDatabase
import com.finder.storage.SuggestionRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class PlacesManagerModule internal constructor(
  private val context: Context
) {

  @Provides
  @Singleton
  fun getNetwork(
    retroFit: Retrofit
  ): PlacesManager {
    return PlacesManager(
      placesApi = retroFit.create(
        PlacesApi::class.java,
      ),
      suggestionRepository = getSuggestionRepository()
    )
  }

  @Provides
  @Singleton
  fun getSuggestionRepository(): SuggestionRepository {
    val appDatabase = Room.databaseBuilder(context,
      SuggestionDatabase::class.java, "suggestions").build()
    return SuggestionRepository(appDatabase.suggestionDao())
  }

  @Provides
  @Singleton
  fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .baseUrl("https://maps.googleapis.com/maps/api/place/")
      .addConverterFactory(MoshiConverterFactory.create())
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .client(okHttpClient)
      .build()
  }

  @Provides
  @Singleton
  fun getOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
      .addInterceptor(httpLoggingInterceptor)
      .build()
  }

  @Provides
  @Singleton
  fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return httpLoggingInterceptor
  }

}