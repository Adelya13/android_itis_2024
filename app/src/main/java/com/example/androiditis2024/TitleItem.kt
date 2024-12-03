package com.example.androiditis2024

import androidx.recyclerview.widget.RecyclerView
import com.example.androiditis2024.databinding.AnimeTitleBinding

class TitleItem(
    private val binding: AnimeTitleBinding
): RecyclerView.ViewHolder(binding.root) {

    fun onBind(title: String){
        binding.sectorTitle.text = title

    }
}