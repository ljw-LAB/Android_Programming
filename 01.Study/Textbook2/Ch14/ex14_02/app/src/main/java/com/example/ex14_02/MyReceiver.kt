package com.example.ex14_02

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        //TODO("MyReceiver.onReceive() is not implemented")
        when(intent?.action){
            Intent.ACTION_SCREEN_ON -> Log.d("kkang", "screen on")
            Intent.ACTION_SCREEN_OFF -> Log.d("kkang", "screen off")

        }
    }
}