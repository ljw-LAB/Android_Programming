package com.example.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_resource.*

class Resource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)
        //1
        val mentt = resources.getString(R.string.hello)
        Log.d("mentt","ment : " + mentt )

        //2
        val ment =getString(R.string.hello)
        Log.d("ment","ment : " + ment )

        //3
        //val color = getColor(R.color.textview_color)
        //Log.d("mentt","color : " + color )
        val color = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
//            getColor(R.color.textview_color)
            button.setBackgroundColor(getColor(R.color.textview_color))
        }
        else
        {
            //resources.getColor(R.color.textview_color)
            button.setBackgroundColor(resources.getColor(R.color.textview_color))
        }

    }
}