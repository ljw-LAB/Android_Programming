package com.acaroom.edu.kt.fragmentex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    var isFragmentLoaded = true
//    private val manager = supportFragmentManager

    // Parcelable로 구현된 person 객체 생성
    val person = Person("Kildong", 5)
    // Serializable로 구현된 child 객체 생성
    val child = ChildData("Joosol", 15)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragmentOne()

        btn_change.setOnClickListener {
            if(isFragmentLoaded) showFragmentTwo() else showFragmentOne()
        }

        btn_sub.setOnClickListener {
            // 인텐트를 이용해 객체 보내기
            val intent = Intent(this, SubActivity::class.java)

            // 1. bundle 객체를 이용해 인텐트에 담아 보내기
            var bundle = Bundle()
            bundle.putParcelable("selected_person", person)
            intent.putExtra("myBundle", bundle)

            // 2. putExtra에 직접 객체 보내기
            //intent.putExtra("selected_person", person)

            // 3. ArrayList를 보내는 경우
            // intent.putParcelableArrayListExtra("myBooks", bookList)

            startActivity(intent)
        }
    }



    fun showFragmentOne() {
        // 번들 데이터를 같이 구성하기위한 컴페니언객체의 메서드 사용
        val fragment = FragmentOne.newInstance("newInstance", 21, child)

        replaceFragment(fragment, R.id.fragment_holder, "one")
        isFragmentLoaded = true

    }

    fun showFragmentTwo() {
        // 일반 생성자 사용
        val fragment = FragmentTwo()

        replaceFragment(fragment, R.id.fragment_holder, "two")
        isFragmentLoaded = false
    }
}

// A. 보일러플레이트 코드를 줄이기 위해 FragmentManager에 확장 함수 사용
//inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
//    val transaction = beginTransaction()
//    transaction.func() // func()는 람다식 매개변수로 받아서 처리
//    transaction.commit()
//}

// B. 더 간략하게 만든 inTransaction 확장 함수
inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit() // func()는 람다식 매개변수로 받아서 처리
}

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int, tag: String){
    supportFragmentManager.inTransaction { add(frameId, fragment, tag) }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int, tag: String) {
    supportFragmentManager.inTransaction{replace(frameId, fragment, tag)}
}