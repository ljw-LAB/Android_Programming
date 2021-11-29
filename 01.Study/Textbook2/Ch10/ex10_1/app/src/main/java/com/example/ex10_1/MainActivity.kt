package com.example.ex10_1

import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val status = ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION")
//        if ( status == PackageManager.PERMISSION_GRANTED){
//            Log.d("kkang", "permission granted")
//        }
//        else
//        {
//            Log.d("kkang", "permission denied")
//        }
//
    //        ActivityCompat.requestPermissions(this, arrayOf<String>("android.permission.ACCESS_FINE_LOCATION"), 100)
    }
}