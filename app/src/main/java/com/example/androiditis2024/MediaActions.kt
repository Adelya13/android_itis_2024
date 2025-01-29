package com.example.androiditis2024

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class MediaActions(val key: Int): Parcelable {
    PLAY(0), STOP(1), PAUSE(2)
}