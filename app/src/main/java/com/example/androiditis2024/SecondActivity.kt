package com.example.androiditis2024

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiditis2024.databinding.SecondActivityBinding

class SecondActivity: AppCompatActivity() {

    private var binding: SecondActivityBinding? = null

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)

        binding = SecondActivityBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
//        setResult(Activity.RESULT_OK, Intent().apply {
//            putExtra("", 1)
//        })
    }
}