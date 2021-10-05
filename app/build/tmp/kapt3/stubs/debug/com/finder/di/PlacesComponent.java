package com.finder.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/finder/di/PlacesComponent;", "", "inject", "", "placesManager", "Lcom/finder/networking/PlacesManager;", "detailViewModel", "Lcom/finder/ui/detail/DetailViewModel;", "mainViewModel", "Lcom/finder/ui/main/MainViewModel;", "app_debug"})
@dagger.Component(modules = {com.finder.di.PlacesManagerModule.class})
@javax.inject.Singleton()
public abstract interface PlacesComponent {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.finder.ui.main.MainViewModel mainViewModel);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.finder.ui.detail.DetailViewModel detailViewModel);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.finder.networking.PlacesManager placesManager);
}