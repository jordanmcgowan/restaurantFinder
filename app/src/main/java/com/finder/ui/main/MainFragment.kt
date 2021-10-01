package com.finder.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.finder.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val compositeDisposable = CompositeDisposable()

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

    }

    private fun render(state: SuggestionState) {
        when (state) {
            is SuggestionState.Loading -> {
                // TODO - Loading spinner
            }
            is SuggestionState.Content -> {
                // TODO - setup adapter and show stuff
            }
            is SuggestionState.Empty -> {
                // TODO - view flipper for empty state?
            }
            is SuggestionState.Error -> {
                // TODO - flush out -- not possible rn
            }
        }
    }

}