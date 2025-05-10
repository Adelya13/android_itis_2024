package com.example.androiditis2024.di.modules


import com.example.androiditis2024.data.api.mapper.WeatherMapper
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers

@Module
class AppModule {

    @Provides
    fun provideWeatherMapper() = WeatherMapper()

    @Provides
    fun provideNetworkDispatcher() = Dispatchers.IO
}