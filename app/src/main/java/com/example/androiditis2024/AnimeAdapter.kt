package com.example.androiditis2024

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.androiditis2024.databinding.ItemAnimeBinding

class AnimeAdapter(
    private val list: List<Anime>,
    private val glide: RequestManager,
    private val listener: (Anime) -> Unit
): RecyclerView.Adapter<AnimeItem>() {

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

    override fun onBindViewHolder(
        holder: AnimeItem,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


}