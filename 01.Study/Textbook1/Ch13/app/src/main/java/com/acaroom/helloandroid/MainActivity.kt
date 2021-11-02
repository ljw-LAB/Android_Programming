package com.acaroom.helloandroid

import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //val dataArray : ArrayList<String> = ArrayList()
    private val petList = arrayListOf<Pet>(
        Pet("British Shorthair", "Male", "4", "british_shorthair"),
        Pet("abyssinian", "Female", "9", "abyssinian"),
        Pet("maine_Coon", "Male", "9", "maine_Coon" ),
        Pet("Ragdoll", "Male", "3", "ragdoll")

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_data_list.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        rv_data_list.setHasFixedSize(true)
        rv_data_list.adapter = ExtensionDataAdapter(petList, this)
        {
            Toast.makeText(
                this,
                "Breed: ${it.breed}, ${it.age}",
                Toast.LENGTH_SHORT
            ).show()
        }
        //addDataArray()
        //rv_data_list.layoutManager = LinearLayoutManager(this)
        //rv_data_list.adapter = DataAdapter(dataArray, this)
        //rv_data_list.adapter = ExtensionDataAdapter(dataArray)
        //val tvTitle = findViewById<TextView>(R.id.tv_title)
        //tvTitle.text = "Hello Kotlin!"
        //tv_title.text = "Hello Kotlin again!~"
        //titleOn()
    }
    
//    private fun addDataArray()
//    {
//        dataArray.add("오리")
//        dataArray.add("호랑이")
//        dataArray.add("여우")
//        dataArray.add("늑대")
//        dataArray.add("오소리")
//        dataArray.add("원숭이")
//        dataArray.add("물개")
//        dataArray.add("펭귄")
//        dataArray.add("하마")
//        dataArray.add("미어켓")
//        dataArray.add("타조")
//
//    }
}


fun MainActivity.titleOn()
{
    //tv_title.text = "Hi! Threre"
    //tv_title.visibility = View.VISIBLE
}