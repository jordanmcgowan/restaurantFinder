package com.finder.ui.main;

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
public final class MainViewModel_MembersInjector implements MembersInjector<MainViewModel> {
  private final Provider<PlacesManager> p0Provider;

  public MainViewModel_MembersInjector(Provider<PlacesManager> p0Provider) {
    this.p0Provider = p0Provider;
  }

  public static MembersInjector<MainViewModel> create(Provider<PlacesManager> p0Provider) {
    return new MainViewModel_MembersInjector(p0Provider);
  }

  @Override
  public void injectMembers(MainViewModel instance) {
    injectSetPlacesManager(instance, p0Provider.get());
  }

  public static void injectSetPlacesManager(MainViewModel instance, PlacesManager p0) {
    instance.setPlacesManager(p0);
  }
}
