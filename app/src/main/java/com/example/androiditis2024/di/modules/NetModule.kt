package com.example.androiditis2024.di.modules

import com.example.androiditis2024.data.api.response.WeatherApi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Qualifier

@Module
class NetModule {

    @Provides
    @KeyInterceptor
//    @Named("KeyInterceptor")
    fun apiKeyInterceptor(): Interceptor = Interceptor { chain ->
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

    @Provides
    @LoggingInterceptor
    fun provideLoggingInterceptor() : Interceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun okHttpClient(
        @KeyInterceptor apiKeyInterceptor : Interceptor,
        @LoggingInterceptor loggingInterceptor: Interceptor,
    ):  OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .also {
                //TODO добавить if
                it.addInterceptor(loggingInterceptor)
            }
            .build()



    @Provides
    fun provideGsonConverter(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun api(
        okHttpClient: OkHttpClient,
        gsonConverter: GsonConverterFactory,
    ): WeatherApi =
        Retrofit.Builder()
            .baseUrl(BASE_URI)
            .addConverterFactory(gsonConverter)
            .client(okHttpClient)
            .build()
            .create(WeatherApi::class.java)

}
private const val BASE_URI = "https://api.openweathermap.org/data/2.5/"
private const val API_KEY = "7a8603b492024eee1ed82c5ac8bf8886"
private const val API_KEY_QUERY = "appid"

@Qualifier
annotation class KeyInterceptor

@Qualifier
annotation class LoggingInterceptor