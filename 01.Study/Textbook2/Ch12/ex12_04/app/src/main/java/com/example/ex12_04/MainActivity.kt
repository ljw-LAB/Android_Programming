package com.example.ex12_04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ex12_04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.extendedFab.setOnClickListener {
            when(binding.extendedFab.isExtended){
                true -> binding.extendedFab.shrink()
                false -> binding.extendedFab.extend()
            }
        }
    }
}