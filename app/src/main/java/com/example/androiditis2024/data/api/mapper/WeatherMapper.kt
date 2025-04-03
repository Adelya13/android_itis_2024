package com.example.androiditis2024.data.api.mapper

import com.example.androiditis2024.data.api.response.WeatherResponse
import com.example.androiditis2024.domain.entities.Weather

class WeatherMapper {
    fun map(response: WeatherResponse) : Weather = Weather (
        id = response.id,
        name = response.name,
        temp = response.main.temp
    )
}