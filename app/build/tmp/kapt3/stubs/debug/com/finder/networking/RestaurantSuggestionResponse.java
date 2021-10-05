package com.finder.networking;

import java.lang.System;

/**
 * Used ONLY for the Suggestions query -- the RestaurantResultResponse is shared, but this is for a
 * list of suggestions
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/finder/networking/RestaurantSuggestionResponse;", "", "results", "", "Lcom/finder/networking/RestaurantResultResponse;", "(Ljava/util/List;)V", "getResults", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
@com.squareup.moshi.JsonClass(generateAdapter = true)
public final class RestaurantSuggestionResponse {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.finder.networking.RestaurantResultResponse> results = null;
    
    /**
     * Used ONLY for the Suggestions query -- the RestaurantResultResponse is shared, but this is for a
     * list of suggestions
     */
    @org.jetbrains.annotations.NotNull()
    public final com.finder.networking.RestaurantSuggestionResponse copy(@org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "results")
    java.util.List<com.finder.networking.RestaurantResultResponse> results) {
        return null;
    }
    
    /**
     * Used ONLY for the Suggestions query -- the RestaurantResultResponse is shared, but this is for a
     * list of suggestions
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Used ONLY for the Suggestions query -- the RestaurantResultResponse is shared, but this is for a
     * list of suggestions
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Used ONLY for the Suggestions query -- the RestaurantResultResponse is shared, but this is for a
     * list of suggestions
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public RestaurantSuggestionResponse(@org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "results")
    java.util.List<com.finder.networking.RestaurantResultResponse> results) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finder.networking.RestaurantResultResponse> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finder.networking.RestaurantResultResponse> getResults() {
        return null;
    }
}