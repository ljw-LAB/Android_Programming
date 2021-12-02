package com.example.ex11_05_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ex11_05_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MyFragmentPagerAdapter(this)
        binding.viewpager.adapter = adapter
    }
}