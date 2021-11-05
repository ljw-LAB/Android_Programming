package com.acaroom.edu.kt.fragmentex

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_fragment_one.*

class FragmentOne : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = arguments?.getString("name")
        val value = arguments?.getInt("value")
        val child = arguments?.getSerializable("child") as ChildData
        Log.d("FragmentOne", "name = $name, value = $value child.name = ${child.name}")
        tv_frag1Text.text = "name = $name, value = $value child.name = ${child.name}"

        val bundle = Bundle()
        bundle.putString("name", "My String")
        val fragmentTwo = FragmentTwo()
        fragmentTwo.arguments = bundle

    }

    companion object {
        // 1. 번들에 데이터를 넣고 이 데이터와 함께 프래그먼트 객체 반환
//        fun newInstance(name: String, value: Int, child: ChildData): FragmentOne {
//            val bundle = Bundle()
//            bundle.putString("name", name)
//            bundle.putInt("value", value)
//            bundle.putSerializable("child", child)
//            val fragment = FragmentOne()
//            fragment.arguments = bundle
//            return fragment
//        }

        // 2. 간략화된 버전
        fun newInstance(name: String, value: Int, child: ChildData) = FragmentOne().withArgs {
                putString("name", name)
                putInt("value", value)
                putSerializable("child", child)
        }
    }
}


inline fun <T: Fragment> T.withArgs(argsBuilder: Bundle.() -> Unit): T = this.apply {
    arguments = Bundle().apply(argsBuilder)
}