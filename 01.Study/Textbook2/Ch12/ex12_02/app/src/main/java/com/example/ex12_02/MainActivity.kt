package com.example.ex12_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.widget.TableLayout
import android.widget.TextView
import com.example.ex12_02.databinding.ActivityMainBinding
import com.example.ex12_02.databinding.ActivityMainBinding.inflate
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main_1)
        val tabLayout = findViewById<TabLayout>(R.id.tablayout)
//        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                val transaction = supportFragmentManager.beginTransaction()
//                when(tab?.text)
//                {
//                    "Tab1" -> transaction.replace(R.id.tabCount, OneFragment())
//                    "Tab2" -> transaction.replace(R.id.tabCount, TwoFragment())
//                    "Tab3" -> transaction.replace(R.id.tabCount, ThreeFragment())
//
//                }
//                TODO("Not yet implemented")
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
//            }
//
//        })

//val tab1 : TabLayout.T = TabLayout(R.id.tabs).newTab()
        val tab1 : TabLayout.Tab = tabLayout.newTab()
        tab1.text = "Tab1"
        tabLayout.addTab(tab1)

        val tab2 : TabLayout.Tab = tabLayout.newTab()
        tab2.text = "Tab2"
        tabLayout.addTab(tab2)

        val tab3 : TabLayout.Tab = tabLayout.newTab()
        tab3.text = "Tab3"
        tabLayout.addTab(tab3)
    }
}
