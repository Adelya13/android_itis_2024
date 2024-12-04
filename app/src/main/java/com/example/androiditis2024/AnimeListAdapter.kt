package com.example.androiditis2024

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.RequestManager
import com.example.androiditis2024.databinding.ItemAnimeBinding

class AnimeListAdapter(
    private val glide: RequestManager,
    private val listener: (BaseItemModel.AnimeUiModel) -> Unit
): ListAdapter<BaseItemModel.AnimeUiModel, AnimeItem>(object: DiffUtil.ItemCallback<BaseItemModel.AnimeUiModel>(){
    override fun areItemsTheSame(
        oldItem: BaseItemModel.AnimeUiModel,
        newItem: BaseItemModel.AnimeUiModel
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: BaseItemModel.AnimeUiModel,
        newItem: BaseItemModel.AnimeUiModel
    ): Boolean = oldItem == newItem

    override fun getChangePayload(
        oldItem: BaseItemModel.AnimeUiModel,
        newItem: BaseItemModel.AnimeUiModel
    ): Any? {
       val bundle = Bundle()
        if (oldItem.name != newItem.name) {
            bundle.putString(KEY_NAME, newItem.name)
        }

        if (oldItem.description != newItem.description) {
            bundle.putString(KEY_DESCRIPTION, newItem.description)
        }

        if (oldItem.isFavourite != newItem.isFavourite) {
            bundle.putBoolean(KEY_FAVOURITE, newItem.isFavourite)
        }
        return if (!bundle.isEmpty) bundle else null
    }

}) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimeItem = AnimeItem(
        binding = ItemAnimeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        listener = listener
    )

    override fun onBindViewHolder(holder: AnimeItem, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onBindViewHolder(holder: AnimeItem, position: Int, payloads: MutableList<Any>) {
        if(payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            holder.update(payloads.last() as Bundle)
        }
    }

    companion object {
        const val KEY_NAME = "name"
        const val KEY_DESCRIPTION = "desc"
        const val KEY_FAVOURITE = "favourite"

    }
}