package com.example.androiditis2024

import androidx.annotation.ColorRes

data class Anime(
    val id: Long,
    val name: String,
    val description: String,
    val imagePath: String
)

sealed class BaseItemModel {
    data class AnimeUiModel(
        val id: Long,
        val name: String,
        val description: String,
        val imagePath: String,
        @ColorRes val titleColor: Int
    ) : BaseItemModel()

    data class Title(
        val title: String
    ): BaseItemModel()
}
