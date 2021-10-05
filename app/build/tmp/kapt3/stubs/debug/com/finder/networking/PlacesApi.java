package com.finder.networking;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\'J&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0006H\'\u00a8\u0006\u000b"}, d2 = {"Lcom/finder/networking/PlacesApi;", "", "fetchRestaurantSuggestionDetails", "Lretrofit2/Call;", "Lcom/finder/networking/RestaurantSuggestionDetailResponse;", "suggestionId", "", "fetchRestaurantSuggestionsBasedOnLocation", "Lcom/finder/networking/RestaurantSuggestionResponse;", "keyword", "location", "app_debug"})
public abstract interface PlacesApi {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "nearbysearch/json?radius=5000&type=restaurant&key=AIzaSyDQSd210wKX_7cz9MELkxhaEOUhFP0AkSk")
    public abstract retrofit2.Call<com.finder.networking.RestaurantSuggestionResponse> fetchRestaurantSuggestionsBasedOnLocation(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "keyword")
    java.lang.String keyword, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "location")
    java.lang.String location);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "details/json?key=AIzaSyDQSd210wKX_7cz9MELkxhaEOUhFP0AkSk")
    public abstract retrofit2.Call<com.finder.networking.RestaurantSuggestionDetailResponse> fetchRestaurantSuggestionDetails(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "place_id")
    java.lang.String suggestionId);
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 3)
    public final class DefaultImpls {
    }
}