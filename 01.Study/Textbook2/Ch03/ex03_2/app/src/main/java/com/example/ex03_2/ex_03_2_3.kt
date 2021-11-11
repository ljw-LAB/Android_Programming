package com.example.ex03_2

//lateinit var data1 : Int    // Error
//lateinit val data2 : String // Error
//lateinit var data5 : String // Success

val data6: Int by lazy {
    println("in lazy......")
    10
}

fun main()
{
    println("in main......")
    println(data6 + 10)
    println(data6 + 10)
}

fun someFun()
{
    var data1 : Int = 10
    var data2 : Int? = null

    data1 = data1+10
    data1 = data1.plus(10)
}
