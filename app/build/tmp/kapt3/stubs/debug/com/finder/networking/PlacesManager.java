package com.finder.networking;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J5\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u0012\u001a\u00020\u000fJ\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0014J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u00142\u0006\u0010\u0016\u001a\u00020\u000fJ\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/finder/networking/PlacesManager;", "", "placesApi", "Lcom/finder/networking/PlacesApi;", "suggestionRepository", "Lcom/finder/storage/SuggestionRepository;", "(Lcom/finder/networking/PlacesApi;Lcom/finder/storage/SuggestionRepository;)V", "fetchGeneralRestaurantSuggestions", "Lio/reactivex/Observable;", "", "Lcom/finder/Suggestion;", "lat", "", "long", "keyword", "", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)Lio/reactivex/Observable;", "fetchSuggestionDetails", "suggestionId", "getCachedSuggestions", "Landroidx/lifecycle/LiveData;", "getSuggestionFromPlaceId", "placeId", "insertOrOverrideSuggestionState", "", "suggestion", "(Lcom/finder/Suggestion;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformSuggestionResponse", "suggestionResponse", "Lcom/finder/networking/RestaurantResultResponse;", "app_debug"})
public final class PlacesManager {
    private final com.finder.networking.PlacesApi placesApi = null;
    private final com.finder.storage.SuggestionRepository suggestionRepository = null;
    
    public PlacesManager(@org.jetbrains.annotations.NotNull()
    com.finder.networking.PlacesApi placesApi, @org.jetbrains.annotations.NotNull()
    com.finder.storage.SuggestionRepository suggestionRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<java.util.List<com.finder.Suggestion>> fetchGeneralRestaurantSuggestions(@org.jetbrains.annotations.Nullable()
    java.lang.Double lat, @org.jetbrains.annotations.Nullable()
    java.lang.Double p1_1663806, @org.jetbrains.annotations.Nullable()
    java.lang.String keyword) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.finder.Suggestion> fetchSuggestionDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String suggestionId) {
        return null;
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
    public final java.lang.Object insertOrOverrideSuggestionState(@org.jetbrains.annotations.NotNull()
    com.finder.Suggestion suggestion, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final com.finder.Suggestion transformSuggestionResponse(com.finder.networking.RestaurantResultResponse suggestionResponse) {
        return null;
    }
}