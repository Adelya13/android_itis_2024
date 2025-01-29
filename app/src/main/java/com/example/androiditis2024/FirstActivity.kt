package com.example.androiditis2024


import android.annotation.SuppressLint
import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.os.Parcelable
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.androiditis2024.TestService.Companion.MEDIA_ACTIONS
import com.example.androiditis2024.databinding.FirstActivityBinding

class FirstActivity: AppCompatActivity() {

    private var binding: FirstActivityBinding? = null

    private var binder: IMusicAidlInterface? = null

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            binder = IMusicAidlInterface.Stub.asInterface(p1)
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            binder = null
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)

        binding = FirstActivityBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding?.let{
            it.btnPlay.setOnClickListener{
                binder?.printHello()
                binder?.playMusic()
//                bindService(
//                  Intent(this, TestService::class.java).apply{
//                    putExtra(MEDIA_ACTIONS, MediaActions.PLAY as Parcelable)
//                  },
//                    connection,
//                    Service.BIND_AUTO_CREATE
//                )

//                startService(Intent(this, TestService::class.java).apply {
//                    putExtra(MEDIA_ACTIONS, MediaActions.PLAY as Parcelable)
//                }, )
            }
            it.btnStop.setOnClickListener{
                binder?.setMusic(Song(
                    raw = R.raw.test
                ))
//                startService(Intent(this, TestService::class.java).apply {
//                    putExtra(MEDIA_ACTIONS, MediaActions.STOP as Parcelable)
//                })
            }

            it.btnPause.setOnClickListener {
                binder?.pauseMusic()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        bindService(
            Intent(this, TestService::class.java).apply{
                putExtra(MEDIA_ACTIONS, MediaActions.PLAY as Parcelable)
            },
            connection,
            Service.BIND_AUTO_CREATE
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}