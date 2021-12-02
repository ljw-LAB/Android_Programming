package com.example.ex11_04_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.Fragment
import android.view.View
import com.example.ex11_04_1.databinding.ActivityMainBinding.inflate
import com.example.ex11_04_1.databinding.ActivityRecycleviewBinding
import com.example.ex11_04_1.databinding.ItemMainBinding
import com.example.ex11_04_1.databinding.ItemMainBinding.inflate


class MyAdapter(val binding: ItemMainBinding) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int{
        TODO()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    TODO()
    }
}

class RecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityRecycleviewBinding.inflate(layoutInflater)
        binding
    }
}

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//    }
//}