package com.example.androiditis2024

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat

class TestService : Service() {

    private val id = 13

    private var mediaPlayer = MediaPlayer()
    private var aidlBinder = object: IMusicAidlInterface.Stub() {
        override fun playMusic() {
            playLocalMusic()
        }

        override fun pauseMusic() {
            pause()
        }

        override fun printHello() {
            Log.e(MEDIA_ACTIONS, "hello")
        }

        override fun setMusic(song: Song?) {
            song?.also {
                mediaPlayer = MediaPlayer.create(applicationContext, it.raw)
            }
        }

    }

    inner class TestBinder : Binder(){
        fun printHello() = Log.e(MEDIA_ACTIONS, "hello")

        fun playMusic() {
            playLocalMusic()
        }

        fun pauseMusic() {
            pause()
        }
    }

    @SuppressLint("ForegroundServiceType")
    override fun onCreate() {
        super.onCreate()
//        startForeground(
//            id,
//            NotificationCompat.Builder(this, "test")
//                .setContentTitle("Service start")
//                .setContentText("Alert")
//                .setSmallIcon(R.drawable.cat)
//                .build()
//        )
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val actions = intent?.getParcelableExtra<MediaActions>(MEDIA_ACTIONS)

        when(actions) {
            MediaActions.PLAY -> play()
            MediaActions.STOP -> stop()
            MediaActions.PAUSE -> pause()
            else -> {}
        }

        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder = aidlBinder

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

    private fun play() {
        Log.e("TestService", "play")
    }


    private fun stop() {
        Log.e("TestService", "stop")
        mediaPlayer.stop()

    }

    private fun pause() {
        Log.e("TestService", "pause")
        mediaPlayer.pause()
    }


    private fun playLocalMusic() {
        if (mediaPlayer.isPlaying) mediaPlayer.stop()
        mediaPlayer.run {
            start()
            setOnCompletionListener {
                stop()
            }
        }
    }

    private fun playRemoteMusic() {
        if (mediaPlayer.isPlaying) mediaPlayer.stop()
        mediaPlayer.run {
            setDataSource("https://music.youtube.com/watch?v=OC5ndy6PxBo&si=wqMk84vwkVSZk5SD")
            prepareAsync()
            setOnCompletionListener {
                start()
            }
        }
    }




    companion object {
        const val MEDIA_ACTIONS = "media_actions"
    }
}