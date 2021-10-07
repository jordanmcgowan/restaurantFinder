package com.finder.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.finder.R
import com.finder.databinding.MainFragmentBinding
import com.finder.networking.SearchResponse
import com.finder.toSuggestionLite
import com.finder.ui.detail.DetailFragment
import com.finder.ui.map.MapFragment

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

    const val TAG = "MainFragmentTag"
  }

  private lateinit var binding: MainFragmentBinding

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
        render(SuggestionState.Loading)
        getSearchSuggestions(lat = lat, long = long, keyword = keyword)
        return true
      }
    })

    binding.favoriteFilterButton.setOnClickListener {
      // When the button is enabled, we'll fetch _just_ the favorite items and show those to the
      // user. When it's disabled, we'll flip back to the search results
      if (binding.favoriteFilterButton.isChecked) {
        viewModel.getCachedSuggestions().observe(viewLifecycleOwner, { suggestions ->
          val favoriteSuggestions = suggestions.filter { it.isFavorite }
          render(SuggestionState.Content(suggestionList = favoriteSuggestions))
        })
      } else {
        // FUTURE IMPROVEMENT - We could use a cached list of items here since we're making an
        // identical request as we did when this screen loading...
        getSearchSuggestions(lat, long)
      }
    }


    binding.suggestionList.apply {
      val suggestionAdapter = SuggestionAdapter(
        actionHandler = ::handleAction
      )
      adapter = suggestionAdapter
      layoutManager = LinearLayoutManager(context)
      isVisible = true
    }

    // Get base suggestions
    getSearchSuggestions(lat, long)

  }

  override fun onResume() {
    super.onResume()
    // Hide the default action bar as it doesn't fit designs
    (activity as AppCompatActivity?)?.supportActionBar?.hide()
  }

  private fun getSearchSuggestions(lat: Double?, long: Double?, keyword: String? = null) {
    viewModel.getSuggestions(lat = lat, long = long, keyword = keyword).observe(viewLifecycleOwner, {
      when (it) {
        is SearchResponse.Success -> {
          if (it.data.isEmpty()) {
            render(SuggestionState.Empty)
          } else {
            render(SuggestionState.Content(suggestionList = it.data))
          }
        }
        is SearchResponse.Error -> {
          render(SuggestionState.Error(message = it.message))
        }
      }
    })
  }

  private fun render(state: SuggestionState) {
    when (state) {
      is SuggestionState.Loading -> {
        binding.progressBar.isVisible = true
        // Make sure the progress bar can always been seen. When we're searching for a keyword, the
        // previous search results will be on the screen and we need to be sure the spinner can be
        // seen
        binding.progressBar.bringToFront()
      }
      is SuggestionState.Content -> {
        binding.progressBar.isVisible = false
        binding.searchLayout.isVisible = true

        viewModel.getCachedSuggestions().observe(viewLifecycleOwner, { suggestions ->

          val officialSuggestions = state.suggestionList.map { individualSuggestion ->
            val matchingSuggestion =
              suggestions.firstOrNull { it.placeId == individualSuggestion.placeId }
            if (matchingSuggestion != null) {
              individualSuggestion.copy(isFavorite = matchingSuggestion.isFavorite)
            } else {
              individualSuggestion
            }
          }

          (binding.suggestionList.adapter as SuggestionAdapter).setSuggestions(officialSuggestions)

          // Setup the FAB to pass the suggestions along to render the map view
          binding.fab.setOnClickListener {
            handleAction(action = SuggestionAction.SeeSuggestionsOnMap(suggestionList = officialSuggestions.map {
              it.toSuggestionLite()
            }))
          }
        })
      }
      is SuggestionState.Empty -> {
        binding.progressBar.isVisible = false
        // We want to be able to search when no results are found -- otherwise this is a
        // dead end
        binding.searchLayout.isVisible = true
        binding.errorState.isVisible = true
        binding.errorText.text = context?.getString(R.string.empty_state_notice)
      }
      is SuggestionState.Error -> {
        binding.progressBar.isVisible = false
        // We want to be able to search when a search fails -- otherwise this is a dead end
        binding.searchLayout.isVisible = true
        binding.errorState.isVisible = true
        binding.errorText.text = state.message
      }
    }
  }


  private fun handleAction(action: SuggestionAction) {
    when (action) {
      is SuggestionAction.SeeSuggestionDetails -> {
        parentFragmentManager.commit {
          // Not super happy with this, but it's enough to get the new Fragment to
          // open. Ideally we could use this binding's root - for some reason
          // `binding.root.id` wasn't working for me, but this did
          replace(
            ((view as ViewGroup).parent as View).id,
            DetailFragment.newInstance(action.suggestion),
            DetailFragment.TAG
          )
          setReorderingAllowed(true)
          addToBackStack(TAG)
        }
      }
      is SuggestionAction.SeeSuggestionsOnMap -> {
        parentFragmentManager.commit {
          replace(
            ((view as ViewGroup).parent as View).id,
            MapFragment.newInstance(action.suggestionList),
            MapFragment.TAG
          )
          setReorderingAllowed(true)
          addToBackStack(TAG)
        }
      }
      is SuggestionAction.UpdateFavoriteState -> {
        viewModel.updateFavoriteState(suggestion = action.suggestion)
      }
    }
  }

}