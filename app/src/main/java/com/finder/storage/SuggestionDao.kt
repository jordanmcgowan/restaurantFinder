package com.finder.storage

import androidx.lifecycle.LiveData
import androidx.room.*
import com.finder.Suggestion

@Dao
interface SuggestionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSuggestion(suggestion: Suggestion)

    @Update
    suspend fun updateSuggestion(suggestion: Suggestion)

    @Query("SELECT * FROM suggestions")
    fun getCachedSuggestions(): LiveData<List<Suggestion>>

    @Query("SELECT * FROM suggestions WHERE placeId IS :placeId")
    fun getSuggestionFromPlaceId(placeId: String): LiveData<Suggestion>
}