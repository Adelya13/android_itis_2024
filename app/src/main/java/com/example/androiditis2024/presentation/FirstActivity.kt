package com.example.androiditis2024.presentation


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.androiditis2024.R
import com.example.androiditis2024.data.WeatherRepositoryImpl
import com.example.androiditis2024.data.api.mapper.WeatherMapper
import com.example.androiditis2024.databinding.FirstActivityBinding
import com.example.androiditis2024.domain.usecase.GetWeatherUseCase
import com.example.androiditis2024.utils.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import retrofit2.HttpException

class FirstActivity: AppCompatActivity() {

    private var binding: FirstActivityBinding? = null

    private lateinit var getWeatherUseCase: GetWeatherUseCase

    private lateinit var viewModel: FirstViewModel

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)

        initObjects()
        initObservers()

        binding = FirstActivityBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding?.button?.setOnClickListener{
            viewModel.onGetWeatherOnClick("kazan")
        }

    }

    private fun initObservers() {
        viewModel.weather.observe(this) {
            it.fold(
                onSuccess = { weather ->
                    Snackbar.make(
                        findViewById(R.id.content),
                        "Температура ${weather.temp}",
                        Snackbar.LENGTH_LONG
                    ).show()
                },
                onFailure = { ex ->
                    Log.e("WeatherException", ex.message.toString())
                }
            )
        }

        viewModel.error.observe(this) {
            when(it) {
                is HttpException -> {

                }
            }
        }
    }

    private fun initObjects() {
        getWeatherUseCase = GetWeatherUseCase(
            weatherRepository = WeatherRepositoryImpl(
                weatherMapping = WeatherMapper()
            )
        )

        viewModel = ViewModelProvider(this, ViewModelFactory(GetWeatherUseCase(
            weatherRepository = WeatherRepositoryImpl(
                weatherMapping = WeatherMapper()
            )
        )))[FirstViewModel::class.java]
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
