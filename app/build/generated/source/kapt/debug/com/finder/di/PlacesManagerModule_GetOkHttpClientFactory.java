package com.finder.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
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
public final class PlacesManagerModule_GetOkHttpClientFactory implements Factory<OkHttpClient> {
  private final PlacesManagerModule module;

  private final Provider<HttpLoggingInterceptor> httpLoggingInterceptorProvider;

  public PlacesManagerModule_GetOkHttpClientFactory(PlacesManagerModule module,
      Provider<HttpLoggingInterceptor> httpLoggingInterceptorProvider) {
    this.module = module;
    this.httpLoggingInterceptorProvider = httpLoggingInterceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return getOkHttpClient(module, httpLoggingInterceptorProvider.get());
  }

  public static PlacesManagerModule_GetOkHttpClientFactory create(PlacesManagerModule module,
      Provider<HttpLoggingInterceptor> httpLoggingInterceptorProvider) {
    return new PlacesManagerModule_GetOkHttpClientFactory(module, httpLoggingInterceptorProvider);
  }

  public static OkHttpClient getOkHttpClient(PlacesManagerModule instance,
      HttpLoggingInterceptor httpLoggingInterceptor) {
    return Preconditions.checkNotNullFromProvides(instance.getOkHttpClient(httpLoggingInterceptor));
  }
}
