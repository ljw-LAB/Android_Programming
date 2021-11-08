package com.acaroom.ankocommonsex

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.design.snackbar

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        info("onCreate() - info message") // 일반 정보
        debug(5) // .toString()이 호출되 문자열로 바뀜
        warn(null) // null로 출력


//        btn_toast.setOnClickListener { // 첫 번째 버튼의 클릭 이벤트 처리
//            // 기존의 Toast
//            Toast.makeText(
//                this, // Toast를 보일 문맥
//                "안녕하세요!", // 보여줄 텍스트
//                Toast.LENGTH_SHORT // 길이
//            ).show()
//        }

        btn_toast.setOnClickListener {
            // Anko의 Toasts
            toast("안녕하세요!") // 짧은 길이의 Toast
            toast(R.string.message)  // 리소스의 메시지 직접 사용하기
            longToast("메시지가 긴 길이를 가지고 있을 때 사용")
        }

        btn_snackbar.setOnClickListener {
            // it.longSnackbar("메시지가 긴 길이를 가지고 있을 때 사용")
            it.snackbar("실행할까요?", "실행") {
                // 클릭 이벤트의 처리 내용
                toast("실행합니다!")
            }

        }
        btn_alert.setOnClickListener {
            alert("애완동물이 있나요?") {
                yesButton { toast("좋아요.") }
                noButton { }
            }.show()
        }
        btn_progress.setOnClickListener {
            val dialog = horizontalProgressBar()
            dialog.progress = 50
        }
        btn_sub.setOnClickListener {
            // 일반적인 액티비티의 시작
//            val intent = Intent(this, SubActivity::class.java)
//            intent.putExtra("id", 5)
//            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
//            startActivity(intent)
            startActivity(intentFor<SubActivity>("id" to 5).singleTop())
        }

    }
}
