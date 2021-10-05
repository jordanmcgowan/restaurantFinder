package com.finder.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.finder.R
import com.finder.databinding.SuggestionItemBinding
import com.finder.Suggestion

typealias SuggestionActionHandler = (SuggestionAction) -> Unit

class SuggestionAdapter(
  private val actionHandler: SuggestionActionHandler
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  private var items: MutableList<Suggestion> = mutableListOf()

  override fun getItemCount(): Int = items.size

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SuggestionViewHolder(
    binding = SuggestionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
    actionHandler = actionHandler
  )


  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    (holder as SuggestionViewHolder).bind(items[position])
  }

  // NOTE - there's only one type here -- we can just set this to a constant
  override fun getItemViewType(position: Int) = 0

  fun setSuggestions(suggestions: List<Suggestion>) {
    items.addAll(suggestions)
  }
}

class SuggestionViewHolder(
  val binding: SuggestionItemBinding,
  private val actionHandler: SuggestionActionHandler
) : RecyclerView.ViewHolder(binding.root) {

  fun bind(suggestion: Suggestion) {
    // TODO - Text is stretching beyond the end constraint and not elipsing
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
      // Only show the divider when we have a priceLevel!
      binding.priceDivider.isVisible = true
    }

    binding.address.text = suggestion.address
    // Only show the rating view if the value is present
    binding.rating.apply {
      suggestion.rating?.let {
        rating = suggestion.rating
        isVisible = true
      }
    }
    binding.ratingCount.text =
      binding.root.context.getString(R.string.rating_count_label, suggestion.ratingCount)

    binding.root.setOnClickListener {
      actionHandler(SuggestionAction.SeeSuggestionDetails(suggestion))
    }

    // The fact this is a check box will handle updates, but not the initial state setting
    binding.favoriteIcon.isChecked = suggestion.isFavorite

    // When the icon is tapped, flip the icon and tell the VM to update the favorite state
    binding.favoriteIcon.setOnCheckedChangeListener {  _, isFavorite ->
      // Since the state of the button should reflect the current isFavorite status, when the button
      // state changes we can send that through as the new state
      actionHandler(SuggestionAction.UpdateFavoriteState(suggestion = suggestion.copy(isFavorite = isFavorite)))
    }
  }
}