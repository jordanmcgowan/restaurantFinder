package com.finder.storage;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0007\u001a\u00020\bH\'J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/finder/storage/SuggestionDao;", "", "getCachedSuggestions", "Landroidx/lifecycle/LiveData;", "", "Lcom/finder/Suggestion;", "getSuggestionFromPlaceId", "placeId", "", "insertSuggestion", "", "suggestion", "(Lcom/finder/Suggestion;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSuggestion", "app_debug"})
public abstract interface SuggestionDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insertSuggestion(@org.jetbrains.annotations.NotNull()
    com.finder.Suggestion suggestion, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateSuggestion(@org.jetbrains.annotations.NotNull()
    com.finder.Suggestion suggestion, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM suggestions")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.finder.Suggestion>> getCachedSuggestions();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM suggestions WHERE placeId IS :placeId")
    public abstract androidx.lifecycle.LiveData<com.finder.Suggestion> getSuggestionFromPlaceId(@org.jetbrains.annotations.NotNull()
    java.lang.String placeId);
}