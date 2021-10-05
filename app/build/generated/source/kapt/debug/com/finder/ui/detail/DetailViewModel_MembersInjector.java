package com.finder.ui.detail;

import com.finder.networking.PlacesManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import javax.annotation.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DetailViewModel_MembersInjector implements MembersInjector<DetailViewModel> {
  private final Provider<PlacesManager> p0Provider;

  public DetailViewModel_MembersInjector(Provider<PlacesManager> p0Provider) {
    this.p0Provider = p0Provider;
  }

  public static MembersInjector<DetailViewModel> create(Provider<PlacesManager> p0Provider) {
    return new DetailViewModel_MembersInjector(p0Provider);
  }

  @Override
  public void injectMembers(DetailViewModel instance) {
    injectSetPlacesManager(instance, p0Provider.get());
  }

  public static void injectSetPlacesManager(DetailViewModel instance, PlacesManager p0) {
    instance.setPlacesManager(p0);
  }
}
