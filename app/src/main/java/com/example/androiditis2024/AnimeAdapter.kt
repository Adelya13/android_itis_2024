package com.example.androiditis2024

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.androiditis2024.databinding.AnimeTitleBinding
import com.example.androiditis2024.databinding.ItemAnimeBinding

class AnimeAdapter(
    private var list: List<BaseItemModel>,
    private val glide: RequestManager,
    private val listener: (BaseItemModel) -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder = when(viewType) {
        R.layout.anime_title -> TitleItem(
            binding = AnimeTitleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

        R.layout.item_anime -> AnimeItem(
            binding = ItemAnimeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            listener = listener
        )
        else -> {
            throw IllegalStateException()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(list[position]) {
            is BaseItemModel.AnimeUiModel -> R.layout.item_anime
            is BaseItemModel.Title -> R.layout.anime_title

        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        when(holder){
            is AnimeItem -> {
                holder.onBind((list[position] as BaseItemModel.AnimeUiModel))
            }
            is TitleItem -> {
                holder.onBind((list[position] as BaseItemModel.Title).title)
            }
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemId(position: Int): Long {
        return when(val item = list[position]){
            is BaseItemModel.AnimeUiModel -> item.id
            is BaseItemModel.Title -> super.getItemId(position)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateDataSet(new: List<BaseItemModel>){
        list = new
        notifyDataSetChanged()
    }

    //Old
    companion object {
        const val TYPE_TITLE = 0
        const val TYPE_ITEM_ANIME = 1
    }
}
