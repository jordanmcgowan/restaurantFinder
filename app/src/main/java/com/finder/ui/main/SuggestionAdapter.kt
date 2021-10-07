package com.finder.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.finder.BuildConfig
import com.finder.R
import com.finder.Suggestion
import com.finder.databinding.SuggestionItemBinding

typealias SuggestionActionHandler = (SuggestionAction) -> Unit

private const val GET_IMAGE_ROOT_URL = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photo_reference="

class SuggestionAdapter(
  private val actionHandler: SuggestionActionHandler
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  private var items: List<Suggestion> = listOf()

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
    items = suggestions
    // FUTURE IMPROVEMENT - find a better way to signal that the list has been updated that forcing
    // the whole thing to refresh
    notifyDataSetChanged()
  }
}

class SuggestionViewHolder(
  val binding: SuggestionItemBinding,
  private val actionHandler: SuggestionActionHandler
) : RecyclerView.ViewHolder(binding.root) {

  fun bind(suggestion: Suggestion) {
    binding.name.text = suggestion.name
    Glide
      .with(binding.root.context)
      .load("$GET_IMAGE_ROOT_URL${suggestion.imageReference}&key=${BuildConfig.apiKey}")
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

    binding.openStatus.apply {
      isVisible = true
      text = if (suggestion.openNow) context.getString(R.string.open_now) else context.getString(R.string.currently_closed)
      setTextColor(if (suggestion.openNow) context.getColor(R.color.light_green) else context.getColor(R.color.dark_grey))
    }

    binding.favoriteIcon.setOnClickListener {
      val isFavorite = binding.favoriteIcon.isChecked
      // Since the state of the button should reflect the current isFavorite status, when the button
      // state changes we can send that through as the new state
      actionHandler(SuggestionAction.UpdateFavoriteState(suggestion = suggestion.copy(isFavorite = isFavorite)))
    }
  }
}