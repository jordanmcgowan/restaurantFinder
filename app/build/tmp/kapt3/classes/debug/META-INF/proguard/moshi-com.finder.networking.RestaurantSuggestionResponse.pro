-if class com.finder.networking.RestaurantSuggestionResponse
-keepnames class com.finder.networking.RestaurantSuggestionResponse
-if class com.finder.networking.RestaurantSuggestionResponse
-keep class com.finder.networking.RestaurantSuggestionResponseJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
