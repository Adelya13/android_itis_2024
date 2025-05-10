package com.example.androiditis2024.domain.repository

import com.example.androiditis2024.domain.entities.Weather


interface WeatherRepository {

    suspend fun getWeather(city: String) : Weather
}