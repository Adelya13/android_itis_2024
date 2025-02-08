package com.example.androiditis2024


import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.androiditis2024.databinding.FirstActivityBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FirstActivity: AppCompatActivity() {

    private var binding: FirstActivityBinding? = null
    private val scope = MainScope()

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)

        binding = FirstActivityBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        lifecycleScope.runCatching {

        }

        try{
            scope.launch {

                val res1 = lifecycleScope.async {
                    getUser(1000)
                }

                val res2 = lifecycleScope.async(Dispatchers.Main) {
                    getUser(2000)
                }

                val res3 = lifecycleScope.async(Dispatchers.Main) {
                    getUser(2000)
                }

                withContext(Dispatchers.Main) {
                    binding?.text?.text = res1.await().name
                }

            }

            val job = lifecycleScope.launch {
                val res1 = lifecycleScope.async {
                    getUser(1000)
                }

                val res2 = lifecycleScope.async {
                    getUser(2000)
                }

                val user1 = res1.await()
                val user2 = res2.await()
                Log.e("Use", user1.name + user2.name)

                Log.e("Use", "hello")
            }

            job.invokeOnCompletion {

            }
        } catch (e: Exception) {
            Log.e("ERRROR!!!", e.message.toString())
        }
//
//        openFileOutput(filename, Context.MODE_PRIVATE).use {
//            it.write(fileContents.toByteArray())
//        }



//        this.buildNotification("jfjfjf") {
//            setContentText()
//            setSmallIcon()
//        }
    }

    private suspend fun getUser(
        time: Long
    ): User = withContext(Dispatchers.IO) {
        if(time <= 1000L) throw RuntimeException("ERROR")
        delay(time)
        User("New")
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
        scope.cancel()
    }
}