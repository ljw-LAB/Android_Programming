package com.example.bmi_calc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText : EditText = findViewById(R.id.heightEditText) // 변수 형식 지정
        val weightEditText = findViewById<EditText>(R.id.weightEditText)   // 암묵적 형식 지정

        val resultButton = findViewById<Button>(R.id.resultButton)
        
        resultButton.setOnClickListener {
            Log.d("MainActivity", "ResultButton이 클릭 되었습니다") // .d, .i 로그 수준을 얘기함 Verbose, Debug

            if(heightEditText.text.isEmpty() || weightEditText.text.isEmpty() )
            {
                Toast.makeText(this , "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 이 아래로는 절대 빈 값이 올2222 수 없음.

            val height : Int = heightEditText.text.toString().toInt()
            val weight : Int = weightEditText?.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)

            Log.d("MainActivity", "height $height, weight $weight") // .d, .i 로그 수준을 얘기함 Verbose, Debug
        }
    }
}