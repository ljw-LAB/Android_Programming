package com.ljwlab.todo_list

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

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val data = arrayListOf<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        data.add(Todo("숙제"))
        data.add(Todo("청소"))


        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = TodoAdapter(data,
                onClickDeleteIcon = {
                    DeleteTodo(it)
                }
        )

        binding.addButton.setOnClickListener{
            addTodo()
        }
    }

    private fun addTodo()
    {
        val todo = Todo(binding.editTextTextPersonName.text.toString())
        data.add(todo)
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }

    private fun DeleteTodo(todo: Todo)
    {
        data.remove(todo)
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }

}

data class Todo(
        val text: String,
        var isDone : Boolean = false
)

    class TodoAdapter(private val dataSet: List<Todo>, val onClickDeleteIcon : (todo : Todo) -> Unit) :
        RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

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
            viewHolder.binding.deleteImageView.setOnClickListener {
                onClickDeleteIcon.invoke(todo)
            }
        }

        override fun getItemCount() = dataSet.size


}