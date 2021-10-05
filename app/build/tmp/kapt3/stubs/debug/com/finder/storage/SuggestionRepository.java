package com.finder.storage;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/finder/storage/SuggestionRepository;", "", "suggestionDao", "Lcom/finder/storage/SuggestionDao;", "(Lcom/finder/storage/SuggestionDao;)V", "getCachedSuggestions", "Landroidx/lifecycle/LiveData;", "", "Lcom/finder/Suggestion;", "getSuggestionFromPlaceId", "placeId", "", "storeSuggestionInDB", "", "suggestion", "(Lcom/finder/Suggestion;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SuggestionRepository {
    private final com.finder.storage.SuggestionDao suggestionDao = null;
    
    public SuggestionRepository(@org.jetbrains.annotations.NotNull()
    com.finder.storage.SuggestionDao suggestionDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.finder.Suggestion>> getCachedSuggestions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.finder.Suggestion> getSuggestionFromPlaceId(@org.jetbrains.annotations.NotNull()
    java.lang.String placeId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object storeSuggestionInDB(@org.jetbrains.annotations.NotNull()
    com.finder.Suggestion suggestion, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}