package com.example.ex05_2

fun main()
{
//    var data : String? = null
//    val length = if(data == null)
//    {
//        0
//    }
//    else
//    {
//        data.length
//    }
//    println("data length : $length")
    var data : String? = null
    println("data length : ${data?.length ?: 0}")

//    var data1 : String = "kkang"
//    //data1 = null // error
//
//    var data2 : String? = "kkang"
//    data2 = null

//    var data1 : String? = "kkang"
//    var length = data.length // error

    var data2 : String? = "kkang"
    var length = data?.length
}