package com.example.androiditis2024

import android.content.Context
import android.util.Log
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import java.io.IOException
import java.util.UUID
import java.util.concurrent.TimeUnit

class NotificationWorkManager(
    applicationContext: Context,
    params: WorkerParameters,
) : CoroutineWorker(applicationContext,params) {

    override suspend fun doWork(): Result = if (runAttemptCount > 3) {
        Result.failure()
    } else {
        try {
            Log.e("NotificationWorkManager", "doWork")

            val x = inputData.getInt(DATA_X_ARG, 0)
            val y = inputData.getInt(DATA_Y_ARG, 0)

            val sum = x+y
            Log.e("NotificationWorkManager", "$x + $y = $sum")

            val output = workDataOf(
                SUM to sum
            )

            Result.success(output)
        } catch (e: IOException) {
            Result.retry()
        }
    }

    companion object {
        private const val DATA_X_ARG = "DATA_X_ARG"
        private const val DATA_Y_ARG = "DATA_Y_ARG"
         const val SUM = "SUM"

        var UUID: UUID? = null

        fun scheduleWork(context: Context, x: Int, y: Int) {
            val data = workDataOf(
                DATA_X_ARG to x,
                DATA_Y_ARG to y,
            )

            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
                .setRequiresBatteryNotLow(true)
                .build()

            val request =
                OneTimeWorkRequestBuilder<NotificationWorkManager>()
                    .setConstraints(constraints)
                    .setInputData(data)
                    .build()

            val periodic = PeriodicWorkRequestBuilder<NotificationWorkManager>(
                repeatInterval = 1, TimeUnit.MINUTES
            )
                .setConstraints(constraints)
                .build()

            UUID = request.id
            WorkManager.getInstance(context).enqueue(request)
        }

    }
}