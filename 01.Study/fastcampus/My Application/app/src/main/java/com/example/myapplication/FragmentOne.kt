package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_one.*

//class  FragmentOne : Fragment()
//{
//    interface onDataPassListener {
//        fun onDataPass(data : String?)
//    }
//    lateinit var dataPassListener : onDataPassListener
//
//    override fun onAttach(context: Context) {
//        Log.d("life_cycle", "F onAttach")
//
//        super.onAttach(context)
//        dataPassListener = context as onDataPassListener //형변환
//
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        Log.d("life_cycle", "F onCreate")
//
//        super.onCreate(savedInstanceState)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        Log.d("life_cycle", "F onCreateView")
//        //fragment가 인터페이스를 처음으로 그릴 때 호출 된다
//        // inflater -> 뷰를 그려주는 역할
//        // container -> 부모 뷰
//        return inflater.inflate(R.layout.fragment_one,container,false)
//       // return super.onCreateView(inflater, container, savedInstanceState)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        Log.d("life_cycle", "F onViewCreated")
//
//        super.onViewCreated(view, savedInstanceState)
//        //val pass : Button by lazy { view.findViewById(R.id.pass) }
//
//        // Activity의 OnCreate에서 했던 작업을 프래그먼트는 여기에서 수행행
//        pass.setOnClickListener{
//                dataPassListener.onDataPass("goodBye")
//
//        }
//        //pass.setOnClickListener {
//        //    dataPassListener.onDataPass("goodBye")
//        //}
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//
//        Log.d("life_cycle", "F onActivityCreated")
//        super.onActivityCreated(savedInstanceState)
//    }
//
//    override fun onStart() {
//
//        Log.d("life_cycle", "F onStart")
//        super.onStart()
//    }
//
//    override fun onResume() {
//
//        Log.d("life_cycle", "F onResume")
//        super.onResume()
//    }
//
//    override fun onPause() {
//
//        Log.d("life_cycle", "F onPause")
//        super.onPause()
//    }
//
//    override fun onStop() {
//
//        Log.d("life_cycle", "F onStop")
//        super.onStop()
//    }
//
//    override fun onDestroyView() {
//
//        Log.d("life_cycle", "F onDestroyView")
//        super.onDestroyView()
//    }
//
//    override fun onDetach() {
//
//        Log.d("life_cycle", "F onDetach")
//        super.onDetach()
//    }
//}