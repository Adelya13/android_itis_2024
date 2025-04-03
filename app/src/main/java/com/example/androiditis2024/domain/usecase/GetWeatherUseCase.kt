package com.example.androiditis2024.domain.usecase

import com.example.androiditis2024.domain.entities.Weather
import com.example.androiditis2024.domain.repository.WeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetWeatherUseCase(
    private val weatherRepository: WeatherRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend operator fun invoke(city: String) : Weather {
        return withContext(dispatcher){
            weatherRepository.getWeather(city)
        }
    }
}