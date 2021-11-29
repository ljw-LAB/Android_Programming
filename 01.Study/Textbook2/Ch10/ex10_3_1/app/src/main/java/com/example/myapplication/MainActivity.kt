package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.databinding.DialogInputBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = DialogInputBinding.inflate(layoutInflater)
        AlertDialog.Builder(this).run {
            setTitle("Input")
            setView(binding.root)
            setPositiveButton("닫기", null)
            show()
        }
    }
}