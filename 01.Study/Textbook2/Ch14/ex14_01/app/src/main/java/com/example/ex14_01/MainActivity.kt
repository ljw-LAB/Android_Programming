package com.example.ex14_01

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MyReceiver : BroadcastReceiver()
{
    override fun onReceive(p0: Context?, p1: Intent?) {
        //
    }
}

class MainActivity : AppCompatActivity() {
    val receiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
        }
    }
    val filter =IntentFilter("Action_RECEIVER")
    override fun registerReceiver(receiver: BroadcastReceiver?, filter: IntentFilter?): Intent? {
        return super.registerReceiver(receiver, filter)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}