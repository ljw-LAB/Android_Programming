package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.security.auth.callback.Callback

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        //http://mellowcode.org/json/students/
        //http://mellowcode.org/test/code/

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/") //서버 도메인 주소
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create((RetrofitService::class.java))

        //GET 요청
        service.getStudentsList().enqueue(object : retrofit2.Callback<ArrayList<PersonFromServer>>{
            override fun onFailure(call: Call<ArrayList<PersonFromServer>>, t: Throwable) {
                Log.d("retrofitt", "ERROR")
            }

            override fun onResponse(
                call: Call<ArrayList<PersonFromServer>>,
                response: Response<ArrayList<PersonFromServer>>
            ) {
                if(response.isSuccessful){
                    val personList = response.body()
                    Log.d("retrofitt", "res : " + personList?.get(0)?.age)

                    val code = response.code()
                    Log.d("retrofitt", "code : " + code)

                    //val error = response.errorBody()
                    val header = response.headers()
                    Log.d("retrofitt", "code : " + header)


                }
            }
        })

        //POST 요청 (1)
//        val params = HashMap<String, Any>()
//        params.put("name", "김개똥")
//        params.put("age", "20")
//        params.put("intro", "안녕하세요요요")
//        service.createStudent(params).enqueue(object : retrofit2.Callback<PersonFromServer>
//        {
//            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
//
//            }
//
//            override fun onResponse(
//                call: Call<PersonFromServer>,
//                response: Response<PersonFromServer>
//            ) {
//                if (response.isSuccessful)
//                {
//                    val person = response.body()
//                    Log.d("retrofitt", "name : " + person?.name)
//                }
//
//            }
//        })
        // POST 요청(2)
        val person = PersonFromServer(name = "김철수", age = 12, intro = "안녕하세요 철수 입니다다다")
        service.createStudentEasy(person).enqueue(object : retrofit2.Callback<PersonFromServer>{
            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
                if (response.isSuccessful)
                {
                    val person = response.body()
                    Log.d("retrofitt", "name : " + person?.name)
                }
            }
        })


    }
}