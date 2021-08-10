package com.ljwlab.todo_list

import android.graphics.Paint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ljwlab.todo_list.databinding.ActivityMainBinding
import com.ljwlab.todo_list.databinding.ItemTodoBinding
import androidx.collection.ArrayMap
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        //data.add(Todo("숙제"))
        //data.add(Todo("청소", true))


        binding.recyclerView.apply {
//            binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = TodoAdapter(
                    emptyList(),
                    //viewModel.data,
                    onClickDeleteIcon = {
                        viewModel.DeleteTodo(it)
                        //binding.recyclerView.adapter?.notifyDataSetChanged()
                                        //DeleteTodo(it)
                    },
                    onClickItem = {
                        viewModel.toggleTodo(it)
                        //binding.recyclerView.adapter?.notifyDataSetChanged()

                        //toggleTodo(it)
                    }

            )
        }

        binding.addButton.setOnClickListener{
            val todo = Todo(binding.editTextTextPersonName.text.toString())
//            addTodo(todo)
            viewModel.addTodo(todo)
            //binding.recyclerView.adapter?.notifyDataSetChanged()
        }
        
        //관찰 UI 업데이트
        viewModel.todoLiveData.observe(this, Observer {
            (binding.recyclerView.adapter as TodoAdapter).setData(it)
        })
    }

//    private  fun toggleTodo(todo:Todo)
//    {
//        todo.isDone = !todo.isDone
//        binding.recyclerView.adapter?.notifyDataSetChanged()
//    }
//
//    private fun addTodo()
//    {
//        val todo = Todo(binding.editTextTextPersonName.text.toString())
//        data.add(todo)
//        binding.recyclerView.adapter?.notifyDataSetChanged()
//    }
//
//    private fun DeleteTodo(todo: Todo)
//    {
//        data.remove(todo)
//        binding.recyclerView.adapter?.notifyDataSetChanged()
//    }

}

data class Todo(
        val text: String,
        var isDone : Boolean = false
)

    class TodoAdapter(private var dataSet: List<Todo>,
                      val onClickDeleteIcon : (todo : Todo) -> Unit,
                      val onClickItem : (todo : Todo) -> Unit
    ) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)
        //{
//            val textView: TextView
//
//            init {
//                textView = view.findViewById(R.id.todo_text)
//            }
//        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TodoAdapter.TodoViewHolder {
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_todo, viewGroup, false)
            return TodoViewHolder(ItemTodoBinding.bind(view))
        }

        override fun onBindViewHolder(viewHolder: TodoViewHolder, position: Int) {
            val todo = dataSet[position]
            viewHolder.binding.todoText.text = todo.text
            //viewHolder.textView.text = dataSet[position].text
            if(todo.isDone)
            {
                viewHolder.binding.todoText.apply {
                    paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                    setTypeface(null, Typeface.ITALIC)
                }
            }
            else
            {
                viewHolder.binding.todoText.apply {
                    paintFlags = 0
                    setTypeface(null, Typeface.NORMAL)

                }
            }

            viewHolder.binding.deleteImageView.setOnClickListener {
                onClickDeleteIcon.invoke(todo)
            }

            viewHolder.binding.root.setOnClickListener {
                onClickItem.invoke(todo)
            }
        }

        override fun getItemCount() = dataSet.size

        fun setData(newData: List<Todo>)
        {
            dataSet = newData
            notifyDataSetChanged()
        }
}

class MainViewModel : ViewModel()
{
    val todoLiveData = MutableLiveData<List<Todo>>()
    private val data = arrayListOf<Todo>()

    fun toggleTodo(todo:Todo)
    {
        todo.isDone = !todo.isDone
        todoLiveData.value = data
    }

    fun addTodo(todo: Todo)
    {
        data.add(todo)
        todoLiveData.value = data
    }

    fun DeleteTodo(todo: Todo)
    {
        data.remove(todo)
        todoLiveData.value = data
    }

}


