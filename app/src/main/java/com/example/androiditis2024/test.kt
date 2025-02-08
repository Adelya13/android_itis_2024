package com.example.androiditis2024

import android.app.Notification
import android.content.Context
import androidx.core.app.NotificationCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


fun main() {

    GlobalScope.launch {

    }

    val result1 = test1 {
        it.append("Hello")
        it.append("world")
        it.append("!")
    }

    val result2 = test2 {
        append("Hello")
        append("world")
        append("!")
    }.apply {  }


    val test = Test {
        append("world")
    }


    val user1 = User("name1")
    val user2 = User("name2")

    user1 += user2
}

fun test1(action: (StringBuilder) -> Unit): String {
    val sb = StringBuilder()
    action(sb)
    return sb.toString()
}

fun test2(action: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
    action(sb)
    return sb.toString()
}

fun Context.buildNotification(
    channelId: String,
    action: NotificationCompat.Builder.() -> Unit
) : Notification {
    val builder = NotificationCompat.Builder(this, channelId)
    builder.action()
    return builder.build()
}

//+ plus
//() invoke