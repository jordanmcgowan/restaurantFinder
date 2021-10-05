package com.finder.ui.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/finder/ui/main/SuggestionAction;", "", "()V", "SeeSuggestionDetails", "SeeSuggestionsOnMap", "UpdateFavoriteState", "Lcom/finder/ui/main/SuggestionAction$SeeSuggestionDetails;", "Lcom/finder/ui/main/SuggestionAction$UpdateFavoriteState;", "Lcom/finder/ui/main/SuggestionAction$SeeSuggestionsOnMap;", "app_debug"})
public abstract class SuggestionAction {
    
    private SuggestionAction() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/finder/ui/main/SuggestionAction$SeeSuggestionDetails;", "Lcom/finder/ui/main/SuggestionAction;", "suggestion", "Lcom/finder/Suggestion;", "(Lcom/finder/Suggestion;)V", "getSuggestion", "()Lcom/finder/Suggestion;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class SeeSuggestionDetails extends com.finder.ui.main.SuggestionAction {
        @org.jetbrains.annotations.NotNull()
        private final com.finder.Suggestion suggestion = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.finder.ui.main.SuggestionAction.SeeSuggestionDetails copy(@org.jetbrains.annotations.NotNull()
        com.finder.Suggestion suggestion) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public SeeSuggestionDetails(@org.jetbrains.annotations.NotNull()
        com.finder.Suggestion suggestion) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.finder.Suggestion component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.finder.Suggestion getSuggestion() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/finder/ui/main/SuggestionAction$UpdateFavoriteState;", "Lcom/finder/ui/main/SuggestionAction;", "suggestion", "Lcom/finder/Suggestion;", "(Lcom/finder/Suggestion;)V", "getSuggestion", "()Lcom/finder/Suggestion;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class UpdateFavoriteState extends com.finder.ui.main.SuggestionAction {
        @org.jetbrains.annotations.NotNull()
        private final com.finder.Suggestion suggestion = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.finder.ui.main.SuggestionAction.UpdateFavoriteState copy(@org.jetbrains.annotations.NotNull()
        com.finder.Suggestion suggestion) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public UpdateFavoriteState(@org.jetbrains.annotations.NotNull()
        com.finder.Suggestion suggestion) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.finder.Suggestion component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.finder.Suggestion getSuggestion() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/finder/ui/main/SuggestionAction$SeeSuggestionsOnMap;", "Lcom/finder/ui/main/SuggestionAction;", "suggestionList", "", "Lcom/finder/SuggestionLite;", "(Ljava/util/List;)V", "getSuggestionList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class SeeSuggestionsOnMap extends com.finder.ui.main.SuggestionAction {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.finder.SuggestionLite> suggestionList = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.finder.ui.main.SuggestionAction.SeeSuggestionsOnMap copy(@org.jetbrains.annotations.NotNull()
        java.util.List<com.finder.SuggestionLite> suggestionList) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public SeeSuggestionsOnMap(@org.jetbrains.annotations.NotNull()
        java.util.List<com.finder.SuggestionLite> suggestionList) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.finder.SuggestionLite> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.finder.SuggestionLite> getSuggestionList() {
            return null;
        }
    }
}