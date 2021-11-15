package com.example.ex04_3

fun main()
{
    class NodDataClass(val name : String, val email : String, val age : Int)
    data class DataClass(val name : String, val email : String, val age : Int)

    val non = NodDataClass("kkang", "a@a.com", 10)
    val data = DataClass("kkang", "a@a.com", 10)

    println("non data class toString : ${non.toString()}")
    println("data class toString : ${data.toString()}")

}