package com.example.androiditis2024

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.androiditis2024.databinding.ItemAnimeBinding

class AnimeItem(
    private val binding: ItemAnimeBinding,
    private val glide: RequestManager,
    private val listener: (Anime) -> Unit
): RecyclerView.ViewHolder(binding.root) {

    fun onBind(anime: Anime){
        with(binding){
            titleAnime.text = anime.name
            descriptionAnime.text = anime.description

            root.setOnClickListener{
                listener.invoke(anime)
            }

            glide.load(anime.imagePath)
                .into(imgAnime)
        }
    }
}