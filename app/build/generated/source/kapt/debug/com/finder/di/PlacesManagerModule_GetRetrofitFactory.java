package com.finder.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PlacesManagerModule_GetRetrofitFactory implements Factory<Retrofit> {
  private final PlacesManagerModule module;

  private final Provider<OkHttpClient> okHttpClientProvider;

  public PlacesManagerModule_GetRetrofitFactory(PlacesManagerModule module,
      Provider<OkHttpClient> okHttpClientProvider) {
    this.module = module;
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public Retrofit get() {
    return getRetrofit(module, okHttpClientProvider.get());
  }

  public static PlacesManagerModule_GetRetrofitFactory create(PlacesManagerModule module,
      Provider<OkHttpClient> okHttpClientProvider) {
    return new PlacesManagerModule_GetRetrofitFactory(module, okHttpClientProvider);
  }

  public static Retrofit getRetrofit(PlacesManagerModule instance, OkHttpClient okHttpClient) {
    return Preconditions.checkNotNullFromProvides(instance.getRetrofit(okHttpClient));
  }
}
