package com.example.ex06_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //setContentView(R.layout.activity_main_1)
        //setContentView(R.layout.activity_main_2)
        //setContentView(R.layout.activity_main_3)
        setContentView(R.layout.activity_main_4)

        val textView1 = findViewById<TextView>(R.id.text1)
    }
}