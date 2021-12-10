package com.example.ex13_03

import android.hardware.input.InputManager
import android.inputmethodservice.Keyboard
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import com.example.ex13_03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager : InputMethod
        val binding = ActivityMainBinding.inflate(layoutInflater)

        binding.showButton.setOnClickListener {
            binding.editView.requestFocus()
            //manager.showSoftInput(binding.editView, InputMethodManager.SHOW_IMPLICIT)
        }

    }
}


