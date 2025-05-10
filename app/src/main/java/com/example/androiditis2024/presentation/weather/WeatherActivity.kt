package com.example.androiditis2024.presentation.weather


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.androiditis2024.App
import com.example.androiditis2024.R
import com.example.androiditis2024.databinding.FirstActivityBinding
import com.example.androiditis2024.utils.AppViewModelFactory
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjection
import retrofit2.HttpException
import javax.inject.Inject

class WeatherActivity: AppCompatActivity() {

    private var binding: FirstActivityBinding? = null

    @Inject
    lateinit var factory: AppViewModelFactory

    private val viewModel: WeatherViewModel by viewModels {
        factory
    }


    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)

//        (application as App).appComponent.inject(this)
        AndroidInjection.inject(this)

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

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
