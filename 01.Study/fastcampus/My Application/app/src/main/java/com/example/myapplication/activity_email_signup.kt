package com.example.myapplication

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_email_signup.*
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class activity_email_signup : AppCompatActivity() {

    lateinit var usernameView: EditText
    lateinit var userPassword1View: EditText
    lateinit var userPassword2View: EditText
    lateinit var registerBtn: TextView
    lateinit var loginBtn : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_signup)

        initView(this@activity_email_signup)
        setupListener(this)

//        register.setOnClickListener{
//            (application as MasterApplication).service.getStudentsList().enqueue(object : Callback<ArrayList<PersonFromServer>>{
//                override fun onFailure(call : Call<ArrayList<PersonFromServer>>, t: Throwable) {
//                }
//                override fun onResponse(
//                        call : Call<ArrayList<PersonFromServer>>,
//                        response: Response<ArrayList<PersonFromServer>>
//                ){
//                }
//            })
//        }
    }

    fun setupListener()
    {
        registerBtn.setOnClickListener{
            register(this@activity_email_signup)
        }
        loginBtn.setOnClickListener {
            val sp = activity.getSharedPreferences("login_sp", Context.MODE_PRIVATE)
            val token = sp.getstring("login_sp", "")
            Log.d("abcc", "token : " + token)

        }
    }

}

    fun register(activity: Activity)
    {
        val username = usernameView.text.toString()
        val password1 = userPassword1View.text.toString()
        val password2 = userPassword2View.text.toString()

        (application as MasterApplication).service.register(
                username, password1, password2
        ).enqueue(object : Callback<User>{
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(activity, "가입에 실패하였습니다.", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    Toast.makeText(activity, "가입에 성공하였습니다.", Toast.LENGTH_LONG).show()
                    val user = response.body()
                    val token = user!!.token!!
                    saveUserToken(token, activity)
                }
            }
        })
    }

    fun saveUserToken(token: String, activity: Activity) {
        val sp = activity.getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("login_sp", token)
        editor.commit()
    }


    fun  initView(activity:Activity)
    {
        usernameView = activity.findViewById(R.id.username_inpubox)
        userPassword1View = activity.findViewById(R.id.password1_inpubox)
        userPassword2View = activity.findViewById(R.id.password2_inpubox)
        registerBtn = activity.findViewById(R.id.register)
        loginBtn = activity.findViewById(R.id.login)
    }

    fun getUserName(): String
    {
        return  usernameView.text.toString()
    }

    fun getUserPassword1(): String
    {
        return userPassword1View.text.toString()
    }

    fun getUserPassword2(): String
    {
        return userPassword2View.text.toString()
    }



}