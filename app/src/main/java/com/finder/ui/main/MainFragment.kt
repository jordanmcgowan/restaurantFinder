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
import com.finder.databinding.MainFragmentBinding
import com.finder.networking.Suggestion
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: MainFragmentBinding


    private val compositeDisposable = CompositeDisposable()

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        viewModel.getSuggestionsBasedOnLocation()

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