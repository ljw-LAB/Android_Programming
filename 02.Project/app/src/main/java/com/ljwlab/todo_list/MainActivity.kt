package com.ljwlab.todo_list

import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
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
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firestore.v1.Value

class MainActivity : AppCompatActivity() {

    val RC_SIGN_IN = 1000

    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        // 로그인이 안됨
        if(FirebaseAuth.getInstance().currentUser == null) {
            login()
        }
        //data.add(Todo("숙제"))
        //data.add(Todo("청소", true))


        binding.recyclerView.apply {
//            binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = TodoAdapter(
                    emptyList(),
                    //viewModel.data,ㅇ
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

    override fun onActivityResult(requestCode : Int, resultCode : Int, data : Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)
            if (requestCode == Activity.RESULT_OK) // 로그인  성공
            {
                //val user = FirebaseAuth.getInstance().currentUser
                viewModel.fetchData()
            } else // 로그인 실패
            {
                finish()
            }
        }
    }

    fun login()
    {
        val providers = arrayListOf(AuthUI.IdpConfig.EmailBuilder().build())

        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
            RC_SIGN_IN)
    }

    fun logout()
    {
        AuthUI.getInstance()
            .signOut(this)
            .addOnCompleteListener {
                login()// ...
            }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return true
        //return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId)
        {
            R.id.action_log_out ->
            {
                logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
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

    class TodoAdapter(private var dataSet: List<DocumentSnapshot>,
                      val onClickDeleteIcon : (todo : DocumentSnapshot) -> Unit,
                      val onClickItem : (todo : DocumentSnapshot) -> Unit
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
            viewHolder.binding.todoText.text = todo.getString("text") ?: ""
            //viewHolder.textView.text = dataSet[position].text
            if((todo.getBoolean("isDone")?:false) == true)
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

        fun setData(newData: List<DocumentSnapshot>)
        {
            dataSet = newData
            notifyDataSetChanged()
        }
}

class MainViewModel : ViewModel()
{
    val db = Firebase.firestore
    val todoLiveData = MutableLiveData<List<DocumentSnapshot>>()

    init {
        fetchData()
    }
    fun fetchData()
    {
        val user = FirebaseAuth.getInstance().currentUser
        if(user != null)
        {
            db.collection(user.uid)
                    .addSnapshotListener { value, e ->
                        if (e != null) {
                            return@addSnapshotListener
                        }
                        if(value != null)
                        {
                            todoLiveData.value = value.documents
                        }

                    }
//                    .get()
//                    .addOnSuccessListener {result ->
//                        data.clear()
//                        for (document in result) {
//                            //Log.d(TAG, "${document.id} => ${document.data}")
//                            val todo = Todo(
//                                    document.data["text"]as String,
//                                    document.data["isDone"]as Boolean
//                            )
//                            data.add(todo)
//                        }
//                        todoLiveData.value =data
//                    }
        }

    }

    fun toggleTodo(todo:DocumentSnapshot)
    {
        FirebaseAuth.getInstance().currentUser?.let { user->
            val isDone = todo.getBoolean("isDone") ?: false
            db.collection(user.uid).document(todo.id).update("isDone", !isDone)
        }
        //todo.isDone = !todo.isDone
        //todoLiveData.value = data
    }

    fun addTodo(todo: Todo)
    {
        FirebaseAuth.getInstance().currentUser?.let { user->
            db.collection(user.uid).add(todo)
        }

//        data.add(todo)
//        todoLiveData.value = data
    }

    fun DeleteTodo(todo: DocumentSnapshot)
    {
        FirebaseAuth.getInstance().currentUser?.let { user->
            db.collection(user.uid).document(todo.id).delete()
        }
        //data.remove(todo)
        //todoLiveData.value = data
    }

}


