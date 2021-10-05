package com.finder.di;

import com.finder.networking.PlacesManager;
import com.finder.ui.detail.DetailViewModel;
import com.finder.ui.detail.DetailViewModel_MembersInjector;
import com.finder.ui.main.MainViewModel;
import com.finder.ui.main.MainViewModel_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
public final class DaggerPlacesComponent implements PlacesComponent {
  private final DaggerPlacesComponent placesComponent = this;

  private Provider<HttpLoggingInterceptor> getHttpLoggingInterceptorProvider;

  private Provider<OkHttpClient> getOkHttpClientProvider;

  private Provider<Retrofit> getRetrofitProvider;

  private Provider<PlacesManager> getNetworkProvider;

  private DaggerPlacesComponent(PlacesManagerModule placesManagerModuleParam) {

    initialize(placesManagerModuleParam);

  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final PlacesManagerModule placesManagerModuleParam) {
    this.getHttpLoggingInterceptorProvider = DoubleCheck.provider(PlacesManagerModule_GetHttpLoggingInterceptorFactory.create(placesManagerModuleParam));
    this.getOkHttpClientProvider = DoubleCheck.provider(PlacesManagerModule_GetOkHttpClientFactory.create(placesManagerModuleParam, getHttpLoggingInterceptorProvider));
    this.getRetrofitProvider = DoubleCheck.provider(PlacesManagerModule_GetRetrofitFactory.create(placesManagerModuleParam, getOkHttpClientProvider));
    this.getNetworkProvider = DoubleCheck.provider(PlacesManagerModule_GetNetworkFactory.create(placesManagerModuleParam, getRetrofitProvider));
  }

  @Override
  public void inject(MainViewModel mainViewModel) {
    injectMainViewModel(mainViewModel);
  }

  @Override
  public void inject(DetailViewModel detailViewModel) {
    injectDetailViewModel(detailViewModel);
  }

  @Override
  public void inject(PlacesManager placesManager) {
  }

  private MainViewModel injectMainViewModel(MainViewModel instance) {
    MainViewModel_MembersInjector.injectSetPlacesManager(instance, getNetworkProvider.get());
    return instance;
  }

  private DetailViewModel injectDetailViewModel(DetailViewModel instance) {
    DetailViewModel_MembersInjector.injectSetPlacesManager(instance, getNetworkProvider.get());
    return instance;
  }

  public static final class Builder {
    private PlacesManagerModule placesManagerModule;

    private Builder() {
    }

    public Builder placesManagerModule(PlacesManagerModule placesManagerModule) {
      this.placesManagerModule = Preconditions.checkNotNull(placesManagerModule);
      return this;
    }

    public PlacesComponent build() {
      Preconditions.checkBuilderRequirement(placesManagerModule, PlacesManagerModule.class);
      return new DaggerPlacesComponent(placesManagerModule);
    }
  }
}
