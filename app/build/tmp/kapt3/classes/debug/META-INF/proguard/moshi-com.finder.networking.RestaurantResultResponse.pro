-if class com.finder.networking.RestaurantResultResponse
-keepnames class com.finder.networking.RestaurantResultResponse
-if class com.finder.networking.RestaurantResultResponse
-keep class com.finder.networking.RestaurantResultResponseJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
-if class com.finder.networking.RestaurantResultResponse
-keepnames class kotlin.jvm.internal.DefaultConstructorMarker
-if class com.finder.networking.RestaurantResultResponse
-keepclassmembers class com.finder.networking.RestaurantResultResponse {
    public synthetic <init>(java.lang.String,java.lang.String,java.lang.String,com.finder.networking.RestaurantGeometryResponse,com.finder.networking.RestaurantOpeningHoursResponse,java.lang.Float,java.lang.Integer,java.lang.Integer,java.util.List,int,kotlin.jvm.internal.DefaultConstructorMarker);
}
