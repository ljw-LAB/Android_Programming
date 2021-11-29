package com.example.ex10_3

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import android.widget.Toast.makeText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val toast = Toast.makeText("this", "종료하려면 한 번더 누르세요.", Toast.LENGTH_SHORT)
        //toast.show()

        setContentView(R.layout.activity_main)
//        DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
//            override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
//                Log.d("kkang", "year : $p1, month : ${p2 + 1}, dayofMonth : $p3")
//            }
//        }, 2020, 8, 21).show()

//        TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener{
//            override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
//                Log.d("kkang", "time : $p1, minuute : $p2")
//            }
//        }, 15, 0, true).show()

//        AlertDialog.Builder(this).run{
//            setTitle("test dialog")
//            setIcon(android.R.drawable.ic_dialog_info)
//            setMessage("정말로 종료하시겠습니까?")
//            setPositiveButton("OK", null)
//            setNegativeButton("Cancel", null)
//            setNeutralButton("More", null)
//            setPositiveButton("Yes", null)
//            setNegativeButton("No", null)
//            show()
//        }
//
//        val eventHandler = object  : DialogInterface.OnClickListener{
//            override fun onClick(p0: DialogInterface?, p1: Int) {
//                if(p1 == DialogInterface.BUTTON_POSITIVE)
//                {
//                    Log.d("kkang", "positive button click")
//                }
//                else if(p1 == DialogInterface.BUTTON_NEGATIVE)
//                {
//                    Log.d("kkang", "negative button click")
//                }
//            }
//        }

        val items = arrayOf<String>("사과", "복숭아", "수박", "딸기")
        AlertDialog.Builder(this).run {
            setTitle("item test")
            setIcon(android.R.drawable.ic_dialog_info)
//            setItems(items, object : DialogInterface.OnClickListener {
//                override fun onClick(p0: DialogInterface?, p1: Int) {
//                    Log.d("kkang", "선택한 과일 : ${items[p1]}")
//                }
//            })

            setPositiveButton("닫기", null)

//            setMultiChoiceItems(items, booleanArrayOf(true, false, true, false), object : DialogInterface.OnMultiChoiceClickListener {
//                override fun onClick(p0: DialogInterface?, p1: Int, p2: Boolean) {
//                    Log.d("kkang", "${items[p1]} 이${if (p2) "선택되었습니다." else "선택 해제되었습니다."}")
//                }
//            })

            setSingleChoiceItems(items, 1, object : DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Log.d("kkang", "${items[p1]}이 선택되었습니다.")
                }
            })
            show()
        }
    }
}