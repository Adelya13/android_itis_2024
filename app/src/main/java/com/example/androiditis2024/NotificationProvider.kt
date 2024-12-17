package com.example.androiditis2024

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.graphics.drawable.toBitmap

class NotificationProvider(private val context: Context) {

    fun showNotification() {
        val vibration = arrayOf(100L, 200L).toLongArray()
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intent = Intent(context, FirstActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            context,
            100,
            intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_MUTABLE
        )

        val builder = NotificationCompat.Builder(context,  context.getString(R.string.default_notification_channel_id))
            .setSmallIcon(R.drawable.cat)
            .setContentTitle("Заголовок")
            .setContentText("Описание")
            .setVibrate(vibration)
            .setLights(Color.RED, 100,500)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .setVisibility(NotificationCompat.VISIBILITY_PRIVATE)
            .setContentIntent(pendingIntent)
            .setLargeIcon(context.getDrawable(R.drawable.cat)?.toBitmap())


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel(
                context.getString(R.string.default_notification_channel_id),
                context.getString(R.string.default_notification_channel_name),
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                lightColor = Color.RED
                vibrationPattern = vibration
                setShowBadge(false)
            }.also {
                notificationManager.createNotificationChannel(it)
            }
        }

        notificationManager.notify(1, builder.build())

    }
}