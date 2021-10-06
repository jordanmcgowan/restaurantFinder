package com.finder

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.finder.storage.SuggestionDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class SuggestionDaoTest {

  @get:Rule
  var executorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

  private val scope = GlobalScope

  lateinit var db: SuggestionDatabase

  @Before
  fun initializeDatabase() {
    db = Room.inMemoryDatabaseBuilder(
      ApplicationProvider.getApplicationContext(),
      SuggestionDatabase::class.java
    )
      .allowMainThreadQueries()
      .build()
  }

  @After
  @Throws(IOException::class)
  fun closeDatabase() {
    db.close()
  }

  @Test
  fun `can insertSuggestion`() {
    val suggestion = Suggestion(
      name = "name1",
      placeId = "placeId1"
    )
    runBlocking {
      scope.launch {
        db.suggestionDao().insertSuggestion(suggestion)
      }
    }
    val elementsInDatabase = db.suggestionDao().getCachedSuggestions().value?.size
    assertEquals(1, elementsInDatabase)
  }

  @Test
  fun `can override existing suggestion with same placeId`() {
    val suggestion = Suggestion(
      name = "name1",
      placeId = "placeId1"
    )

    runBlocking {
      scope.launch {
        db.suggestionDao().insertSuggestion(suggestion)
      }
    }
    assertEquals("name1", db.suggestionDao().getCachedSuggestions().value?.get(0)?.name)

    runBlocking {
      scope.launch {
        db.suggestionDao().insertSuggestion(suggestion.copy(name = "name2"))
      }
    }
    assertEquals("name1", db.suggestionDao().getCachedSuggestions().value?.get(0)?.name)
  }




}

