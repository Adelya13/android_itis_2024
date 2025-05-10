package com.example.androiditis2024.presentation.weather

import androidx.lifecycle.ViewModel
import com.example.androiditis2024.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WeatherModule {

    @Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel::class)
    fun bindWeatherViewModel(
        viewModel: WeatherViewModel
    ): ViewModel
}