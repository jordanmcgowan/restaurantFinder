package com.finder.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.finder.R
import com.finder.databinding.DetailFragmentBinding
import com.finder.databinding.MainFragmentBinding
import com.finder.ui.detail.DetailFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

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
        println("JORDAN - onViewCreated")

        compositeDisposable.add(
            viewModel.state()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        render(it)
                    },
                    {
                        println("ERROR! ${it.localizedMessage}")
                    }
                )
        )

        // Get base suggestions
        viewModel.getSuggestionsBasedOnLocation(
            lat = arguments?.getDouble(LAT_PARAM),
            long = arguments?.getDouble(LONG_PARAM)
        )

    }

    private fun render(state: SuggestionState) {
        when (state) {
            is SuggestionState.Loading -> {
                binding.progressBar.isVisible = true
            }
            is SuggestionState.Content -> {
                binding.progressBar.isVisible = false
                binding.suggestionList.apply {
                    val suggestionAdapter = SuggestionAdapter(
                        actionHandler = ::handleAction
                    )
                    suggestionAdapter.setSuggestions(state.suggestionList)
                    adapter = suggestionAdapter
                    layoutManager = LinearLayoutManager(context)
                    // TODO - spacing divider?
                    isVisible = true
                }
            }
            is SuggestionState.Empty -> {
                // TODO - view flipper for empty state?
            }
            is SuggestionState.Error -> {
                // TODO - flush out -- not possible rn
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
        }
    }

}