package com.example.ex14_02

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    val filter = IntentFilter(Intent.ACTION_SCREEN_ON).apply {
        addAction(Intent.ACTION_BATTERY_OKAY)
        addAction(Intent.ACTION_BATTERY_CHANGED)
        addAction(Intent.ACTION_POWER_CONNECTED)
        addAction(Intent.ACTION_POWER_DISCONNECTED)

    }
    override fun registerReceiver(receiver: BroadcastReceiver?, filter: IntentFilter?): Intent? {
        return super.registerReceiver(receiver, filter)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    val receiver = object : BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            when(intent?.action){
                Intent.ACTION_BATTERY_OKAY -> Log.d("kkang", "ACTION_BATTERY_OKAY" )
                Intent.ACTION_BATTERY_LOW -> Log.d("kkang", "ACTION_BATTERY_LOW ")
                Intent.ACTION_BATTERY_CHANGED -> Log.d("kkang", "ACTION_BATTERY_CHANGED")
                Intent.ACTION_POWER_CONNECTED -> Log.d("kkang", "ACTION_POWER_CONNECTED")
                Intent.ACTION_POWER_DISCONNECTED -> Log.d("kkang", "ACTION_POWER_DISCONNECTED")
            }
        }
    }

    
}