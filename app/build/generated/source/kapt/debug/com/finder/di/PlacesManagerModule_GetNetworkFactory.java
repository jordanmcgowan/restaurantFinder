package com.finder.di;

import com.finder.networking.PlacesManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
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
public final class PlacesManagerModule_GetNetworkFactory implements Factory<PlacesManager> {
  private final PlacesManagerModule module;

  private final Provider<Retrofit> retroFitProvider;

  public PlacesManagerModule_GetNetworkFactory(PlacesManagerModule module,
      Provider<Retrofit> retroFitProvider) {
    this.module = module;
    this.retroFitProvider = retroFitProvider;
  }

  @Override
  public PlacesManager get() {
    return getNetwork(module, retroFitProvider.get());
  }

  public static PlacesManagerModule_GetNetworkFactory create(PlacesManagerModule module,
      Provider<Retrofit> retroFitProvider) {
    return new PlacesManagerModule_GetNetworkFactory(module, retroFitProvider);
  }

  public static PlacesManager getNetwork(PlacesManagerModule instance, Retrofit retroFit) {
    return Preconditions.checkNotNullFromProvides(instance.getNetwork(retroFit));
  }
}
