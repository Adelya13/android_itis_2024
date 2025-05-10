package com.example.androiditis2024.di.modules

import com.example.androiditis2024.di.scope.ActivityScope
import com.example.androiditis2024.presentation.weather.WeatherActivity
import com.example.androiditis2024.presentation.weather.WeatherModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindsModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [WeatherModule::class])
    fun contributeWeatherActivity(): WeatherActivity

}