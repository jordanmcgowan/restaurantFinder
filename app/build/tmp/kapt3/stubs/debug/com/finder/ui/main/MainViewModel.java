package com.finder.ui.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011J/\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0002\u0010\u001bJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cJ\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@GX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR2\u0010\f\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\r0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/finder/ui/main/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "<set-?>", "Lcom/finder/networking/PlacesManager;", "placesManager", "getPlacesManager", "()Lcom/finder/networking/PlacesManager;", "setPlacesManager", "(Lcom/finder/networking/PlacesManager;)V", "state", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/finder/ui/main/SuggestionState;", "kotlin.jvm.PlatformType", "getCachedSuggestions", "Landroidx/lifecycle/LiveData;", "", "Lcom/finder/Suggestion;", "getSuggestions", "", "lat", "", "long", "keyword", "", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)V", "Lio/reactivex/Observable;", "updateFavoriteState", "suggestion", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    public com.finder.networking.PlacesManager placesManager;
    private final io.reactivex.disposables.CompositeDisposable compositeDisposable = null;
    private final io.reactivex.subjects.BehaviorSubject<com.finder.ui.main.SuggestionState> state = null;
    
    public MainViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finder.networking.PlacesManager getPlacesManager() {
        return null;
    }
    
    @javax.inject.Inject()
    public final void setPlacesManager(@org.jetbrains.annotations.NotNull()
    com.finder.networking.PlacesManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.finder.ui.main.SuggestionState> state() {
        return null;
    }
    
    public final void getSuggestions(@org.jetbrains.annotations.Nullable()
    java.lang.Double lat, @org.jetbrains.annotations.Nullable()
    java.lang.Double p1_1663806, @org.jetbrains.annotations.Nullable()
    java.lang.String keyword) {
    }
    
    public final void updateFavoriteState(@org.jetbrains.annotations.NotNull()
    com.finder.Suggestion suggestion) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.finder.Suggestion>> getCachedSuggestions() {
        return null;
    }
}