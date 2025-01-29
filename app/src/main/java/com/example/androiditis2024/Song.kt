package com.example.androiditis2024

import android.os.Parcelable
import androidx.annotation.RawRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Song(
    val id: Int = 0,
    @RawRes val raw: Int,
    val name: String = "NONE"
) : Parcelable
