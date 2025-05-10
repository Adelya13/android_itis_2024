package com.example.androiditis2024.di.modules

import com.example.androiditis2024.data.WeatherRepositoryImpl
import com.example.androiditis2024.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindWeatherInterface(impl: WeatherRepositoryImpl) : WeatherRepository
}