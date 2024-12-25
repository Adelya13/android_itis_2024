package com.example.androiditis2024

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyBroadcastReceiver: BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        p1?.getIntExtra("KEY", 0)

    }
}