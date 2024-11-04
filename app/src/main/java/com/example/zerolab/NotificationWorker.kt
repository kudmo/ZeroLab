package com.example.zerolab

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

val messages = setOf("12 кафедра говорит \"завтра\", но сделай сегодня ",
                    "Домашка требует выполнения, милорд",
                    "Дедлайны страшны, не приближайся к ним")
class NotificationWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {
    override fun doWork(): Result {
        sendNotification(applicationContext)
        Log.d("worker", "DO DOD OD OD OD OD ODOD O DO DO DODO")
        return Result.success()
    }
    private fun sendNotification(context: Context) {
        val notification = NotificationCompat.Builder(context, "daily_notification")
            .setSmallIcon(android.R.drawable.ic_dialog_email)
            .setContentTitle("Homework!!")
            .setContentText(messages.random())
            .setAutoCancel(true)
            .build()
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("daily_notification", "Daily Reminder", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }
        notificationManager.notify(1, notification) // 1 - ID уведомления
    }
}

