package com.example.ex13_01

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val intent : Intent= Intent(this, DetailActivity::class.java)
//        startActivity(intent)
//
        val intent : Intent= Intent(this, DetailActivity::class.java)
        startActivity(intent)

        intent.putExtra("data1", "hello")
        intent.putExtra("data2", 10)

        val data1 = intent.getStringExtra("data1")
        val data2 = intent.getIntExtra("data2", 0)

        startActivityForResult(intent, 10)

        intent.putExtra("resultData", "world")
        setResult(RESULT_OK, intent)
        finish()


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 10 && resultCode == Activity.RESULT_OK)
        {
            val result = data?.getStringExtra("resultData")
        }
    }
}