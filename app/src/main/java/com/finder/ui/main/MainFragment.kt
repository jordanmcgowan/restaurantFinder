package com.finder.ui.main

import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.finder.databinding.MainFragmentBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

private const val LAT_PARAM = "lat_bundle_param"
private const val LONG_PARAM = "long_bundle_param"


class MainFragment : Fragment() {

    companion object {
        fun newInstance(
            lat: Double,
            long: Double
        ) : MainFragment {
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
                // TODO - Loading spinner
            }
            is SuggestionState.Content -> {
                // TODO - setup adapter and show stuff
                binding.suggestionList.apply {
                    val suggestionAdapter = SuggestionAdapter(
                        actionHandler = ::handleAction
                    )
                    suggestionAdapter.setSuggestions(state.suggestionList)
                    adapter = suggestionAdapter
                    layoutManager = LinearLayoutManager(context)
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


    private fun handleAction(action: SuggestionAction){
        when (action) {
            is SuggestionAction.SeeSuggestionDetails -> {
                // TODO - navigate to next fragment
            }
        }
    }

}