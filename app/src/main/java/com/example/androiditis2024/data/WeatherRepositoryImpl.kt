package com.example.androiditis2024.data

import com.example.androiditis2024.data.api.mapper.WeatherMapper
import com.example.androiditis2024.data.api.response.WeatherApi
import com.example.androiditis2024.domain.entities.Weather
import com.example.androiditis2024.domain.repository.WeatherRepository
import javax.inject.Inject


class WeatherRepositoryImpl @Inject constructor(
    private val weatherMapping: WeatherMapper,
    val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeather(city: String) : Weather {
        return weatherMapping.map(api.getWeather(city))
    }
}