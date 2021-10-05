package com.finder.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.finder.Suggestion

@Database(entities = [Suggestion::class], version = 1)
abstract class SuggestionDatabase : RoomDatabase() {
    abstract fun suggestionDao(): SuggestionDao
}