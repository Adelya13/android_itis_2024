package com.example.androiditis2024.data.api.response

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather?lang=ru&units=metric")
    suspend fun getWeather(@Query("q") city: String) : WeatherResponse
}