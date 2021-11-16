package com.example.ex05_2

//fun main()
//{
//    var data : String? = "kkang"
//    println("data = $data : ${data?.length ?: -1}")
//    data = null
//    println("data = $data : ${data?.length ?: -1}")
//}

fun some(data : String?) : Int
{
    return data!!.length
}

fun main()
{
    println(some("kkang"))
    println(some(null))
}
