package com.finder.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.finder.databinding.SuggestionItemBinding
import com.finder.networking.Suggestion

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
        // TODO - flush out views
        binding.name.text = suggestion.name
        binding.address.text = suggestion.address
        // Only show the rating view if the value is present
        binding.rating.apply {
            suggestion.rating?.let {
                rating = suggestion.rating
                isVisible = true
            }
        }
        binding.root.setOnClickListener {
            actionHandler(SuggestionAction.SeeSuggestionDetails(suggestion))
        }
    }
}