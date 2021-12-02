package com.example.ex11_02_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ex11_02_1.databinding.ActivityMainBinding
import com.example.ex11_02_1.databinding.ToolbarBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ToolbarBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbar)
    }
}