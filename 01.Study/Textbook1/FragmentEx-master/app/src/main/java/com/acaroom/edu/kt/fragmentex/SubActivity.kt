package com.acaroom.edu.kt.fragmentex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        // 1. 번들로부터 Parcelable 객체를 받아오기
        val bundle = intent.getBundleExtra("myBundle")
        var person  = bundle.getParcelable<Person>("selected_person") as Person


        // 2. extras에서 직접 가져오기
//        val bundle = intent.extras
//        val child = bundle!!.getParcelable<Person>("selected_person")

        // 3. ArrayList로부터 받는 경우
        // Intent i = getIntent();
        // bookList = i.getParcelableArrayListExtra("myBooks");

        textView.text = "person.name = ${person.name}, person.age = ${person.age}"

    }
}
