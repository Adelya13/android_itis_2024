package com.example.androiditis2024.data

import com.example.androiditis2024.data.api.WeatherResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRepository {

    private val apiKeyInterceptor = Interceptor { chain ->
        val original = chain.request()
        val newUrl = original.url.newBuilder()
            .addQueryParameter(API_KEY_QUERY, API_KEY)
            .build()

        chain.proceed(
            original.newBuilder()
                .url(newUrl)
                .build()
        )
    }


    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .also {
                //TODO добавить if
                it.addInterceptor(HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
                )
            }
            .build()
    }


    private val api: WeatherApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URI)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(WeatherApi::class.java)

    }

    suspend fun getWeather(city: String) : WeatherResponse {
        return api.getWeather(city)
    }
}

private const val BASE_URI = "https://api.openweathermap.org/data/2.5/"
private const val API_KEY = "7a8603b492024eee1ed82c5ac8bf8886"
private const val API_KEY_QUERY = "appid"