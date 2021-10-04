package com.finder.ui.detail

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.finder.R
import com.finder.databinding.DetailFragmentBinding
import com.finder.networking.Suggestion
import com.finder.ui.main.SuggestionAction
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
                val suggestion = state.suggestion
                binding.name.text = suggestion.name
                Glide
                    .with(binding.root.context)
                    .load("https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photo_reference=${suggestion.imageReference}&key=AIzaSyDQSd210wKX_7cz9MELkxhaEOUhFP0AkSk")
                    .into(binding.image)
                val priceLevelText = when (suggestion.priceLevel) {
                    1 -> "$"
                    2 -> "$$"
                    3 -> "$$$"
                    4 -> "$$$$"
                    // Best option here is just a null string -- show nothing
                    else -> null
                }

                priceLevelText?.let {
                    binding.priceLevel.apply {
                        text = it
                        isVisible = true
                    }
                }

                binding.address.apply {
                    text = suggestion.address
                    paintFlags = Paint.UNDERLINE_TEXT_FLAG
                    setOnClickListener {
                        // Set the coords based on the precise location and add the address to show
                        // a pin on the map
                        val gmmIntentUri = Uri.parse("geo:${suggestion.lat},${suggestion.long}?q=${suggestion.address}")
                        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                        // We could force Maps usage, but the Launcher knows the packages that could
                        // be used -- we can let the user decide.
                        // mapIntent.setPackage("com.google.android.apps.maps")
                        startActivity(mapIntent)
                    }
                }


                binding.address.text = suggestion.address
                // Only show the rating view if the value is present
                binding.rating.apply {
                    suggestion.rating?.let {
                        rating = suggestion.rating
                        isVisible = true
                    }
                }
                binding.ratingCount.text = binding.root.context.getString(R.string.rating_count_label, suggestion.ratingCount)

            }
            is DetailState.Error -> {
                // TODO - flush out -- not possible rn
            }
        }
    }
}