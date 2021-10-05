package com.finder.networking;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0003\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u00a2\u0006\u0002\u0010\u0012J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010!J\u0010\u0010*\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001eJ\u0010\u0010+\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001eJ\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u00c6\u0003J\u0080\u0001\u0010-\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0010\b\u0003\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u00c6\u0001\u00a2\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00102\u001a\u00020\rH\u00d6\u0001J\t\u00103\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0015\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b#\u0010\u001e\u00a8\u00064"}, d2 = {"Lcom/finder/networking/RestaurantResultResponse;", "", "name", "", "placeId", "formattedAddress", "geometry", "Lcom/finder/networking/RestaurantGeometryResponse;", "hoursResponse", "Lcom/finder/networking/RestaurantOpeningHoursResponse;", "rating", "", "ratingCount", "", "priceLevel", "photos", "", "Lcom/finder/networking/RestaurantPhotosResponse;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/finder/networking/RestaurantGeometryResponse;Lcom/finder/networking/RestaurantOpeningHoursResponse;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getFormattedAddress", "()Ljava/lang/String;", "getGeometry", "()Lcom/finder/networking/RestaurantGeometryResponse;", "getHoursResponse", "()Lcom/finder/networking/RestaurantOpeningHoursResponse;", "getName", "getPhotos", "()Ljava/util/List;", "getPlaceId", "getPriceLevel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRating", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getRatingCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/finder/networking/RestaurantGeometryResponse;Lcom/finder/networking/RestaurantOpeningHoursResponse;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lcom/finder/networking/RestaurantResultResponse;", "equals", "", "other", "hashCode", "toString", "app_debug"})
@com.squareup.moshi.JsonClass(generateAdapter = true)
public final class RestaurantResultResponse {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String placeId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String formattedAddress = null;
    @org.jetbrains.annotations.Nullable()
    private final com.finder.networking.RestaurantGeometryResponse geometry = null;
    @org.jetbrains.annotations.Nullable()
    private final com.finder.networking.RestaurantOpeningHoursResponse hoursResponse = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Float rating = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer ratingCount = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer priceLevel = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.finder.networking.RestaurantPhotosResponse> photos = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.finder.networking.RestaurantResultResponse copy(@org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "name")
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "place_id")
    java.lang.String placeId, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "vicinity")
    java.lang.String formattedAddress, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "geometry")
    com.finder.networking.RestaurantGeometryResponse geometry, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "opening_hours")
    com.finder.networking.RestaurantOpeningHoursResponse hoursResponse, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "rating")
    java.lang.Float rating, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "user_ratings_total")
    java.lang.Integer ratingCount, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "price_level")
    java.lang.Integer priceLevel, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "photos")
    java.util.List<com.finder.networking.RestaurantPhotosResponse> photos) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public RestaurantResultResponse() {
        super();
    }
    
    public RestaurantResultResponse(@org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "name")
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "place_id")
    java.lang.String placeId, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "vicinity")
    java.lang.String formattedAddress, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "geometry")
    com.finder.networking.RestaurantGeometryResponse geometry, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "opening_hours")
    com.finder.networking.RestaurantOpeningHoursResponse hoursResponse, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "rating")
    java.lang.Float rating, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "user_ratings_total")
    java.lang.Integer ratingCount, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "price_level")
    java.lang.Integer priceLevel, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "photos")
    java.util.List<com.finder.networking.RestaurantPhotosResponse> photos) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPlaceId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFormattedAddress() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finder.networking.RestaurantGeometryResponse component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finder.networking.RestaurantGeometryResponse getGeometry() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finder.networking.RestaurantOpeningHoursResponse component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finder.networking.RestaurantOpeningHoursResponse getHoursResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float getRating() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getRatingCount() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getPriceLevel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.finder.networking.RestaurantPhotosResponse> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.finder.networking.RestaurantPhotosResponse> getPhotos() {
        return null;
    }
}