package com.example.androiditis2024

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiditis2024.FirstActivity.Companion.VALUE_ARGS
import com.example.androiditis2024.databinding.SecondActivityBinding

class SecondActivity: AppCompatActivity() {

    private  lateinit var binding: SecondActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        binding = SecondActivityBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        val value = intent.getIntExtra(VALUE_ARGS, 0)

        binding.tvText.text = "SECOND ACTIVITY VALUE: $value"

    }

    companion object {
        fun start(activity: Activity, value: Int){
            val intent = Intent(activity, SecondActivity::class.java)
            intent.putExtra(VALUE_ARGS, value)
            activity.startActivity(intent)
        }
    }
}