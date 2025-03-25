package com.example.androiditis2024


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.androiditis2024.data.WeatherRepository
import com.example.androiditis2024.databinding.FirstActivityBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class FirstActivity: AppCompatActivity() {

    private var binding: FirstActivityBinding? = null

    private val repository by lazy {
        WeatherRepository()
    }

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)

        binding = FirstActivityBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding?.button?.setOnClickListener{
            lifecycleScope.launch {
                try {
                    val response = repository.getWeather("Kazan")
                    Snackbar.make(
                        findViewById(R.id.content),
                        "Температура ${response.main.temp}",
                        Snackbar.LENGTH_LONG
                    ).show()
                } catch (ex: Exception) {
                    Log.e("WeatherException", ex.message.toString())
                }
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
