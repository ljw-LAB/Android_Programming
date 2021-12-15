package com.example.ex15_04

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.app.job.JobService
import android.content.ComponentName
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.content.getSystemService

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var jobScheduler : JobScheduler? = getSystemService<JobScheduler>()
        JobInfo.Builder(1, ComponentName(this, MyJobService::class.java)).run {
            setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
            jobScheduler?.schedule(build())
        }

    }
}