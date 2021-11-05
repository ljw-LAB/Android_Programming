package com.acaroom.countdownex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countTask(tv_count, btn_start, btn_stop) // ① 합성 프로퍼티에 의한 리소스의 접근
    }
}
fun countTask(count: TextView, start: Button, stop: Button) {
    // ② Dispatchers.Main -> UI 문맥에서 코루틴 실행, ③ 늦은 실행을 위한 LAZY 지정
    val job = GlobalScope.launch(Dispatchers.Main, start = CoroutineStart.LAZY) {
        for (i in 10 downTo 1) { // 카운트다운
            count.text = "Countdown $i ..." //  ④ UI 업데이트
            delay(1000)
        }
        count.text = "Done!"
    }
    start.setOnClickListener { job.start() }
    stop.setOnClickListener { job.cancel() }
}
