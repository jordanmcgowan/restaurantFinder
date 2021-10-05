-if class com.finder.networking.RestaurantOpeningHoursResponse
-keepnames class com.finder.networking.RestaurantOpeningHoursResponse
-if class com.finder.networking.RestaurantOpeningHoursResponse
-keep class com.finder.networking.RestaurantOpeningHoursResponseJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
