package com.finder.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.finder.databinding.DetailFragmentBinding
import com.finder.networking.Suggestion
import com.finder.ui.main.SuggestionAdapter
import com.finder.ui.main.SuggestionState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

private const val KEY_SUGGESTION_ID = "key.suggestion_id"

class DetailFragment: Fragment() {

    companion object {
        fun newInstance(
            suggestion: Suggestion
        ) : DetailFragment {
            return DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_SUGGESTION_ID, suggestion.placeId)
                }
            }
        }

        val TAG = "DetailFragmentTag"
    }

    private val compositeDisposable = CompositeDisposable()

    private val viewModel: DetailViewModel by viewModels()

    private lateinit var binding: DetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.name.text = "I DID IT"

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
        viewModel.getSuggestionDetails(
            suggestionId = arguments?.getString(KEY_SUGGESTION_ID)
        )

    }

    private fun render(state: DetailState) {
        when (state) {
            is DetailState.Loading -> {
                // TODO
//                binding.progressBar.isVisible = true
            }
            is DetailState.Content -> {
                binding.name.text = state.suggestion.name
            }
            is DetailState.Error -> {
                // TODO - flush out -- not possible rn
            }
        }
    }
}