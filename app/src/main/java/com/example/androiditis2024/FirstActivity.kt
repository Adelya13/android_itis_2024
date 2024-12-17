package com.example.androiditis2024


import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.androiditis2024.databinding.FirstActivityBinding

class FirstActivity: AppCompatActivity() {

    private var binding: FirstActivityBinding? = null
    private var notificationProvider: NotificationProvider? = null

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)
        notificationProvider = NotificationProvider(this)

        binding = FirstActivityBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        notificationProvider?.showNotification()

        when(intent.extras?.getString("NAVIGATION")){
            "PROFILE"-> {
                //navigate profile fragment
            }
            "MAIN"-> {
                //navigate main fragment
            }
            "SETTINGS"-> {
                //navigate settings fragment
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
        notificationProvider = null
    }
}