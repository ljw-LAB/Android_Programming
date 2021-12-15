package com.example.ex15_04

import android.annotation.TargetApi
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.content.getSystemService

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
class MyJobService : JobService() {

    override fun onCreate() {
        super.onCreate()
        Log.d("kknag", "MyJobService......OnCreate()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("kknag", "MyJobService......OnDestroy()")
    }
    override fun onStartJob(params:JobParameters): Boolean
    {
        Log.d("kknag", "MyJobService......OnStartJob()")
        return false
    }
    override fun onStopJob(params:JobParameters): Boolean
    {
        Log.d("kknag", "MyJobService......OnStopJob()")
        return false
    }

//    override fun onBind(intent: Intent): IBinder {
//        TODO("Return the communication channel to the service.")
//    }
}