package com.example.androiditis2024.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androiditis2024.domain.usecase.GetWeatherUseCase
import com.example.androiditis2024.presentation.FirstViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(FirstViewModel::class.java) ->
                FirstViewModel(getWeatherUseCase) as? T ?: throw IllegalArgumentException("Unknown ViewModel class")

            else -> {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
}

