package com.example.androiditis2024


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.androiditis2024.NotificationWorkManager.Companion.SUM
import com.example.androiditis2024.databinding.FirstActivityBinding
import com.google.android.material.snackbar.Snackbar

class FirstActivity: AppCompatActivity() {

    private var binding: FirstActivityBinding? = null

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)

        binding = FirstActivityBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding?.run {
            button.setOnClickListener {
                startWorker()
            }
        }

    }

    private fun startWorker() {
//        Constraints.Builder()
//            .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
//            .setRequiresBatteryNotLow(true)
//            .build()
//            .also {
//                OneTimeWorkRequestBuilder<NotificationWorkManager>()
//                    .setConstraints(it)
//                    .build()
//                    .also { manager ->
//                        WorkManager.getInstance(this).enqueue(manager)
//                    }
//            }

//        val constraints =   Constraints.Builder()
//            .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
//            .setRequiresBatteryNotLow(true)
//            .build()
//
//        val request =
//            OneTimeWorkRequestBuilder<NotificationWorkManager>()
//                .setConstraints(constraints)
//                .build()
//
//        val periodic = PeriodicWorkRequestBuilder<NotificationWorkManager>(
//            repeatInterval = 1, TimeUnit.MINUTES
//        )
//            .setConstraints(constraints)
//            .build()
//
//        WorkManager.getInstance(applicationContext).enqueue(periodic)

        NotificationWorkManager.scheduleWork(
            context = this,
            x = 3,
            y = 7,
        )

        NotificationWorkManager.UUID?.let {
            WorkManager.getInstance(this).getWorkInfoByIdLiveData(it)
                .observe(this) { info ->
                    info?.let {
                        if (info.state == WorkInfo.State.SUCCEEDED) {
                            info.outputData.getInt(SUM, -1).also {
                                Snackbar.make(
                                    findViewById(R.id.button),
                                    "SUM: $it",
                                    Snackbar.LENGTH_LONG
                                ).show()
                            }
                        }
                    }
                }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}