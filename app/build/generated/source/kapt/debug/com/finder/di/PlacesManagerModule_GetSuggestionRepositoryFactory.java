package com.finder.di;

import com.finder.storage.SuggestionRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PlacesManagerModule_GetSuggestionRepositoryFactory implements Factory<SuggestionRepository> {
  private final PlacesManagerModule module;

  public PlacesManagerModule_GetSuggestionRepositoryFactory(PlacesManagerModule module) {
    this.module = module;
  }

  @Override
  public SuggestionRepository get() {
    return getSuggestionRepository(module);
  }

  public static PlacesManagerModule_GetSuggestionRepositoryFactory create(
      PlacesManagerModule module) {
    return new PlacesManagerModule_GetSuggestionRepositoryFactory(module);
  }

  public static SuggestionRepository getSuggestionRepository(PlacesManagerModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.getSuggestionRepository());
  }
}
