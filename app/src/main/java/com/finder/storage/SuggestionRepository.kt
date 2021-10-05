package com.finder.storage

import androidx.lifecycle.LiveData
import com.finder.Suggestion

class SuggestionRepository(private val suggestionDao: SuggestionDao) {


    fun getCachedSuggestions(): LiveData<List<Suggestion>> {
        return suggestionDao.getCachedSuggestions()
    }

    fun getSuggestionFromPlaceId(placeId: String): LiveData<Suggestion> {
        return suggestionDao.getSuggestionFromPlaceId(placeId = placeId)
    }

    // To simplify DB interactions we can just overwrite the entry every time. It's not ideal, but
    // it works. I had a simple @Update method in place, but since not every item in within the DB,
    // you would have to query the DB to see if an entry already exists, then write an entry OR
    // update one. This is simpler for this task.
    // This works since the placeId (which is always consistent for every suggestion) is the primary
    // key in the DB. It will see a match and override
    suspend fun storeSuggestionInDB(suggestion: Suggestion) {
        suggestionDao.insertSuggestion(suggestion)
    }
}