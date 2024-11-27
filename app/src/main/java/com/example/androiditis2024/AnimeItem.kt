package com.example.androiditis2024

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Priority
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.androiditis2024.databinding.ItemAnimeBinding

class AnimeItem(
    private val binding: ItemAnimeBinding,
    private val glide: RequestManager,
    private val listener: (Anime) -> Unit
): RecyclerView.ViewHolder(binding.root) {

    private val option = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)

    fun onBind(anime: Anime){
        with(binding){
            titleAnime.text = anime.name
            descriptionAnime.text = anime.description

            root.setOnClickListener{
                listener.invoke(anime)
            }

            glide
                .load(anime.imagePath)
                .placeholder(R.drawable.cat)
                .error(R.drawable.cat)
                .apply(option)
                .into(imgAnime)
        }
    }
}