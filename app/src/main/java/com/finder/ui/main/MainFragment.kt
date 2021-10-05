package com.finder.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.finder.databinding.MainFragmentBinding
import com.finder.ui.detail.DetailFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

private const val LAT_PARAM = "lat_bundle_param"
private const val LONG_PARAM = "long_bundle_param"


class MainFragment : Fragment() {

  companion object {
    fun newInstance(
      lat: Double,
      long: Double
    ): MainFragment {
      return MainFragment().apply {
        arguments = Bundle().apply {
          putDouble(LAT_PARAM, lat)
          putDouble(LONG_PARAM, long)
        }
      }
    }
  }

  private lateinit var binding: MainFragmentBinding

  private val compositeDisposable = CompositeDisposable()

  private val viewModel: MainViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = MainFragmentBinding.inflate(layoutInflater)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val lat = arguments?.getDouble(LAT_PARAM)
    val long = arguments?.getDouble(LONG_PARAM)

    binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
      override fun onQueryTextChange(p0: String?): Boolean {
        // Do nothing -- we will only handle the submit button taps. We could implement this
        // if we wanted to handle search suggestions/typeahead/autofill
        return false
      }

      override fun onQueryTextSubmit(keyword: String?): Boolean {
        viewModel.getSuggestions(lat = lat, long = long, keyword = keyword)
        return true
      }
    })


    compositeDisposable.add(
      viewModel.state()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
          {
            render(it)
          },
          {
            // TODO (with more time) - log this to BugSnag and alert on it
            println("ERROR! ${it.localizedMessage}")
          }
        )
    )

    // Get base suggestions
    viewModel.getSuggestions(lat = lat, long = long)

  }

  override fun onResume() {
    super.onResume()
    // Hide the default action bar as it doesn't fit designs
    (activity as AppCompatActivity?)?.supportActionBar?.hide()
  }

  private fun render(state: SuggestionState) {
    when (state) {
      is SuggestionState.Loading -> {
        binding.viewFlipper.displayedChild(binding.contentContainer)
        binding.progressBar.isVisible = true
      }
      is SuggestionState.Content -> {

        // TODO -  I think this is causing the entire adapter to rebind and lose teh scroll state...
        viewModel.getCachedSuggestions().observe(viewLifecycleOwner, Observer { suggestions ->

          val officialSuggestions = state.suggestionList.map { individualSuggestion ->
            val matchingSuggestion =
              suggestions.firstOrNull { it.placeId == individualSuggestion.placeId }
            if (matchingSuggestion != null) {
              individualSuggestion.copy(isFavorite = matchingSuggestion.isFavorite)
            } else {
              individualSuggestion
            }
          }

          binding.progressBar.isVisible = false
          binding.searchLayout.isVisible = true
          binding.suggestionList.apply {
            val suggestionAdapter = SuggestionAdapter(
              actionHandler = ::handleAction
            )
            suggestionAdapter.setSuggestions(officialSuggestions)
            adapter = suggestionAdapter
            layoutManager = LinearLayoutManager(context)
            isVisible = true
          }
        })
      }
      is SuggestionState.Empty -> {
        binding.progressBar.isVisible = false
        // We want to be able to search when no results are found -- otherwise this is a
        // dead end
        binding.searchLayout.isVisible = true
        // TODO - no results view
      }
      is SuggestionState.Error -> {
        // TODO - show more in this...
        // We want to be able to search when a search fails -- otherwise this is a dead end
        binding.searchLayout.isVisible = true
        binding.viewFlipper.displayedChild(binding.errorState)
      }
    }
  }


  private fun handleAction(action: SuggestionAction) {
    when (action) {
      is SuggestionAction.SeeSuggestionDetails -> {
        parentFragmentManager.beginTransaction()
          .replace(
            // Not super happy with this, but it's enough to get the new Fragment to
            // open. Ideally we could use this binding's root - for some reason
            // `binding.root.id` wasn't working for me, but this did
            ((view as ViewGroup).parent as View).id,
            DetailFragment.newInstance(suggestion = action.suggestion),
            DetailFragment.TAG
          )
          .addToBackStack(null)
          .commit()
      }
      is SuggestionAction.UpdateFavoriteState -> {
        viewModel.updateFavoriteState(action.suggestion)
      }
    }
  }

}

infix fun ViewGroup.displayedChild(view: View?) {
  for (index in 0 until childCount) {
    val child = getChildAt(index)
    child.isVisible = child === view
  }
}