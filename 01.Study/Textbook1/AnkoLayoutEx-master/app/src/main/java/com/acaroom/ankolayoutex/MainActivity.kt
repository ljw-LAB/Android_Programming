package com.acaroom.ankolayoutex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.button
import org.jetbrains.anko.editText
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    //    setContentView(R.layout.activity_main)

        // DSL 형태의 UI 작성
        verticalLayout {  // vertical 속성을 가진 LinearLayout
            val name = editText() { hint = "Name" } // EditText의 객체
            button("Say Hello") {  // Button 뷰
                onClick { toast("Hello, ${name.text}!") }  // 클릭 이벤트 처리
            }
        }


    }


}
