package com.example.androiditis2024

import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Priority
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.androiditis2024.AnimeListAdapter.Companion.KEY_DESCRIPTION
import com.example.androiditis2024.AnimeListAdapter.Companion.KEY_FAVOURITE
import com.example.androiditis2024.AnimeListAdapter.Companion.KEY_NAME
import com.example.androiditis2024.databinding.ItemAnimeBinding

class AnimeItem(
    private val binding: ItemAnimeBinding,
    private val glide: RequestManager,
    private val listener: (BaseItemModel.AnimeUiModel) -> Unit
): RecyclerView.ViewHolder(binding.root) {

    private val option = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)

    fun onBind(anime: BaseItemModel.AnimeUiModel){
        with(binding){
            titleAnime.text = anime.name
            descriptionAnime.text = anime.description

            titleAnime.setTextColor(itemView.context.getColor(anime.titleColor))
            root.setOnClickListener{
                listener.invoke(anime)
            }

            btnFavourite.setFavourite(anime.isFavourite)

            glide
                .load(anime.imagePath)
                .placeholder(R.drawable.cat)
                .error(R.drawable.cat)
                .apply(option)
                .into(imgAnime)
        }
    }

     fun update(bundle: Bundle){
        if (bundle.containsKey(KEY_NAME)) {
            bundle.getString(KEY_NAME).also {
                binding.titleAnime.text = it
            }
        }
        if (bundle.containsKey(KEY_DESCRIPTION)) {
            bundle.getString(KEY_DESCRIPTION).also {
                binding.descriptionAnime.text = it
            }
        }

        if (bundle.containsKey(KEY_FAVOURITE)) {
            bundle.getBoolean(KEY_FAVOURITE).also {
                binding.btnFavourite.setFavourite(it)
            }
        }
    }

    private fun ImageView.setFavourite(isFavourite: Boolean){
        setImageResource(
            if (isFavourite) {
                R.drawable.baseline_favorite_24
            } else {
                R.drawable.baseline_favorite_border_24
            }
        )
    }
}