package com.acaroom.countdownex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        countTask(tv_count, btn_start, btn_stop)
    }
}

fun countTask(count : TextView, start : Button, stop : Button)
{
    val job = GlobalScope.launch(Dispatchers.Main, start = CoroutineStart.LAZY) {
        for (i in 10 downTo 1){
            count.text = "CountDown $i ..."
            delay(1000)
        }
        count.text = "Done!"
    }
    start.setOnClickListener{job.start()}
    stop.setOnClickListener{job.cancel()}

}