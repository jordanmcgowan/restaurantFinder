// Generated by view binder compiler. Do not edit!
package com.finder.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.finder.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MainFragmentBinding implements ViewBinding {
  @NonNull
  private final ViewFlipper rootView;

  @NonNull
  public final ConstraintLayout contentContainer;

  @NonNull
  public final ConstraintLayout errorState;

  @NonNull
  public final TextView headerTitle;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final ConstraintLayout searchLayout;

  @NonNull
  public final SearchView searchView;

  @NonNull
  public final RecyclerView suggestionList;

  @NonNull
  public final ViewFlipper viewFlipper;

  private MainFragmentBinding(@NonNull ViewFlipper rootView,
      @NonNull ConstraintLayout contentContainer, @NonNull ConstraintLayout errorState,
      @NonNull TextView headerTitle, @NonNull ProgressBar progressBar,
      @NonNull ConstraintLayout searchLayout, @NonNull SearchView searchView,
      @NonNull RecyclerView suggestionList, @NonNull ViewFlipper viewFlipper) {
    this.rootView = rootView;
    this.contentContainer = contentContainer;
    this.errorState = errorState;
    this.headerTitle = headerTitle;
    this.progressBar = progressBar;
    this.searchLayout = searchLayout;
    this.searchView = searchView;
    this.suggestionList = suggestionList;
    this.viewFlipper = viewFlipper;
  }

  @Override
  @NonNull
  public ViewFlipper getRoot() {
    return rootView;
  }

  @NonNull
  public static MainFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MainFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.main_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MainFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.content_container;
      ConstraintLayout contentContainer = ViewBindings.findChildViewById(rootView, id);
      if (contentContainer == null) {
        break missingId;
      }

      id = R.id.error_state;
      ConstraintLayout errorState = ViewBindings.findChildViewById(rootView, id);
      if (errorState == null) {
        break missingId;
      }

      id = R.id.header_title;
      TextView headerTitle = ViewBindings.findChildViewById(rootView, id);
      if (headerTitle == null) {
        break missingId;
      }

      id = R.id.progress_bar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.search_layout;
      ConstraintLayout searchLayout = ViewBindings.findChildViewById(rootView, id);
      if (searchLayout == null) {
        break missingId;
      }

      id = R.id.search_view;
      SearchView searchView = ViewBindings.findChildViewById(rootView, id);
      if (searchView == null) {
        break missingId;
      }

      id = R.id.suggestion_list;
      RecyclerView suggestionList = ViewBindings.findChildViewById(rootView, id);
      if (suggestionList == null) {
        break missingId;
      }

      ViewFlipper viewFlipper = (ViewFlipper) rootView;

      return new MainFragmentBinding((ViewFlipper) rootView, contentContainer, errorState,
          headerTitle, progressBar, searchLayout, searchView, suggestionList, viewFlipper);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}