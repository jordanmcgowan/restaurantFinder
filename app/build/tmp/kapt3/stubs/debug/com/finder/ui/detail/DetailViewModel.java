package com.finder.ui.detail;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0013J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0018J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@GX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR2\u0010\f\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\r0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/finder/ui/detail/DetailViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "<set-?>", "Lcom/finder/networking/PlacesManager;", "placesManager", "getPlacesManager", "()Lcom/finder/networking/PlacesManager;", "setPlacesManager", "(Lcom/finder/networking/PlacesManager;)V", "state", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/finder/ui/detail/DetailState;", "kotlin.jvm.PlatformType", "getSuggestionDetails", "", "suggestionId", "", "getSuggestionFromPlaceId", "Landroidx/lifecycle/LiveData;", "Lcom/finder/Suggestion;", "placeId", "Lio/reactivex/Observable;", "updateFavoriteState", "suggestion", "app_debug"})
public final class DetailViewModel extends androidx.lifecycle.ViewModel {
    public com.finder.networking.PlacesManager placesManager;
    private final io.reactivex.disposables.CompositeDisposable compositeDisposable = null;
    private final io.reactivex.subjects.BehaviorSubject<com.finder.ui.detail.DetailState> state = null;
    
    public DetailViewModel() {
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
    public final io.reactivex.Observable<com.finder.ui.detail.DetailState> state() {
        return null;
    }
    
    public final void getSuggestionDetails(@org.jetbrains.annotations.Nullable()
    java.lang.String suggestionId) {
    }
    
    public final void updateFavoriteState(@org.jetbrains.annotations.NotNull()
    com.finder.Suggestion suggestion) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.finder.Suggestion> getSuggestionFromPlaceId(@org.jetbrains.annotations.NotNull()
    java.lang.String placeId) {
        return null;
    }
}