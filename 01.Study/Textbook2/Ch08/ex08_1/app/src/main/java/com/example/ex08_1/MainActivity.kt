package com.example.ex08_1

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.View.inflate
import android.widget.*
import androidx.core.view.get
import com.example.ex08_1.R.layout.activity_main
import com.example.ex08_1.databinding.ActivityMainBinding


var count : Int = 0
val items = arrayListOf<String>("hello", "world", "kkang")

class MyCheckBoxEventHandler : CompoundButton.OnCheckedChangeListener
{
    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        Log.d("kkang", "체크박스 클릭 활성화 유뮤 $p1")
    }
}

class MyButtonEventHandler : View.OnClickListener {
    override fun onClick(p0: View?) {
        Log.d("kkang", "버튼 클릭 ${count++}")
    }

}

class MyListViewEventHandler() : AdapterView.OnItemClickListener{
    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val item_1 = p0?.adapter?.getItem(p2)
        Log.d("kkang", "리스뷰 클릭 $item_1")
    }
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(activity_main)


        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val simpleListAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, items)

        binding.ListView1.adapter = simpleListAdapter
        binding.checkbox1.setOnCheckedChangeListener(MyCheckBoxEventHandler())
        binding.Button1.setOnClickListener(MyButtonEventHandler())
        binding.ListView1.onItemClickListener = MyListViewEventHandler()
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when(event?.action) {

//            MotionEvent.ACTION_DOWN -> {
//                Log.d("kkang", "Touch down event")
//            }
//
//            MotionEvent.ACTION_UP -> {
//                Log.d("kkang", "Touch Up event")
//            }

            MotionEvent.ACTION_DOWN -> {
                Log.d("kkang", "Touch down event : ${event.x}, ${event.rawX}")
            }
        }
        return super.onTouchEvent(event)
    }

//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        Log.d("kkang", "onKeyDown")
//        return super.onKeyDown(keyCode, event)
//    }
//
//    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
//        Log.d("kkang", "onKeyUp")
//        return super.onKeyUp(keyCode, event)
//    }

//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        when(keyCode){
//            KeyEvent.KEYCODE_0 -> Log.d("kkang", "0 키를 눌렀네요")
//            KeyEvent.KEYCODE_A -> Log.d("kkang", "A 키를 눌렀네요")
//        }
//        return super.onKeyDown(keyCode, event)
//    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when(keyCode)
        {
            KeyEvent.KEYCODE_BACK -> Log.d("kkang", "BACK Button1을 눌렀네요")
            KeyEvent.KEYCODE_VOLUME_UP -> Log.d("kkang", "Volume Up을 눌렀네요")
            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.d("kkang", "Volume Down을 눌렀네요")
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onBackPressed() {
        Log.d("kkang", "Back Button2을 눌렀네요")
        //super.onBackPressed()
    }


}