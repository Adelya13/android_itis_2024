package com.example.androiditis2024.data

import com.example.androiditis2024.data.api.mapper.WeatherMapper
import com.example.androiditis2024.data.api.response.WeatherApi
import com.example.androiditis2024.domain.entities.Weather
import com.example.androiditis2024.domain.repository.WeatherRepository
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRepositoryImpl(
//    private val api: WeatherApi,
//    private val dbDao: Dao,
//    private val memory: Memory,
    val weatherMapping: WeatherMapper,
) : WeatherRepository {

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

    override suspend fun getWeather(city: String) : Weather {
        return weatherMapping.map(api.getWeather(city))
    }
}

private const val BASE_URI = "https://api.openweathermap.org/data/2.5/"
private const val API_KEY = "7a8603b492024eee1ed82c5ac8bf8886"
private const val API_KEY_QUERY = "appid"