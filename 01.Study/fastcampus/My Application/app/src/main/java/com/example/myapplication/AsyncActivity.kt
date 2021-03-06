package com.example.myapplication

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_async.*
import java.lang.Exception
import kotlin.math.log

class AsyncActivity : AppCompatActivity() {
    var task : BackgroundAsyncTask? = null
    var task1 : BackgroundAsyncTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        //task = BackgroundAsyncTask(progressbar, ment)

        start.setOnClickListener{
            task = BackgroundAsyncTask(progressbar, ment)
            task1 = BackgroundAsyncTask(progressbar, ment)
            task?.execute()
            task1?.execute()

        }
        stop.setOnClickListener{
         //   task?.cancel(true)
            startActivity(Intent(this, Intent2::class.java))

        }
    }

    override fun onPause() {
        task?.cancel(true)
        super.onPause()
    }

}

class BackgroundAsyncTask(
    val Progressbar : ProgressBar,
    val progressText : TextView
) : AsyncTask<Int, Int, Int>(){
    //params -> doInBackground에서 사용할 타입
    // progress -> onProgressUpate에서 사용할 타입
    // result -> onPostExecute에서 사용할 타입
    var percent : Int = 0

    override fun onPreExecute() {
        percent = 0
        Progressbar.setProgress(percent)
    }

    override fun doInBackground(vararg params: Int?): Int {
        while (isCancelled() == false)
        {
            percent++
           //Log.d("async", "value : " + percent)
            Log.d("async", "percent : " + percent)
            if(percent > 100)
                break
            else
            {
                publishProgress(percent)
            }
            try {
                Thread.sleep(100)
            }
            catch (e:Exception)
            {
                e.printStackTrace()
            }
        }
        return percent
    }

    override fun onProgressUpdate(vararg values: Int?) {
        Progressbar.setProgress(values[0] ?: 0)
        progressText.setText("퍼센트 : " + values[0])
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Int?) {
        progressText.setText("작업이 완료되었습니다")
    }

    override fun onCancelled() {
        Progressbar.setProgress(0)
        progressText.setText("작업이 취소되었습니다")
    }
}