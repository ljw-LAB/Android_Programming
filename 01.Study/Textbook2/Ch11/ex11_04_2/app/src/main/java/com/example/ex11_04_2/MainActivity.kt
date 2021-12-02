package com.example.ex11_04_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.GridLayout
import androidx.constraintlayout.helper.widget.Carousel
import androidx.recyclerview.widget.*
import com.example.ex11_04_2.databinding.ActivityRecyclerViewBinding
import com.example.ex11_04_2.databinding.ItemMainBinding

val datas = mutableListOf<String>()

class MyAdapter(val binding: MutableList<String>):
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int = datas.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("kkang", "onBindViewHolder : $position")

        val binding = (holder as MyViewHolder).binding
        binding.itemData.text = datas[position]
        binding.itemRoot.setOnClickListener{
            Log.d("kkang", "item root click : $position")
        }

    }
}

class MyViewHolder(val binding: ItemMainBinding ) : RecyclerView.ViewHolder(binding.root)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        for(i in 1..10)
        {
            datas.add("Item $i")
        }

        //binding.recycleView.layoutManager = LinearLayoutManager(this)

        //val layoutManager = LinearLayoutManager(this)
        //layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        //binding.recycleView.layoutManager = layoutManager

        //val layoutManager = GridLayoutManager(this, 2)
        //binding.recycleView.layoutManager = layoutManager

        //val layoutManager = GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, false)
        //binding.recycleView.layoutManager = layoutManager

        //val layoutManager = GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, true)
        //binding.recycleView.layoutManager = layoutManager

        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recycleView.layoutManager = layoutManager

        binding.recycleView.adapter = MyAdapter(datas)
        binding.recycleView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        datas.add("new data")
        binding.recycleView.adapter?.notifyDataSetChanged()

    }
}