package com.finder.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.logging.HttpLoggingInterceptor;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PlacesManagerModule_GetHttpLoggingInterceptorFactory implements Factory<HttpLoggingInterceptor> {
  private final PlacesManagerModule module;

  public PlacesManagerModule_GetHttpLoggingInterceptorFactory(PlacesManagerModule module) {
    this.module = module;
  }

  @Override
  public HttpLoggingInterceptor get() {
    return getHttpLoggingInterceptor(module);
  }

  public static PlacesManagerModule_GetHttpLoggingInterceptorFactory create(
      PlacesManagerModule module) {
    return new PlacesManagerModule_GetHttpLoggingInterceptorFactory(module);
  }

  public static HttpLoggingInterceptor getHttpLoggingInterceptor(PlacesManagerModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.getHttpLoggingInterceptor());
  }
}
