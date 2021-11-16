package com.example.ex05_1

fun main()
{
//    val some = {no : Int -> println(no)}
//    some(10)

//    val some : (Int) -> Unit = { println(it)}
//    some(10)

    val some = {no1: Int, no2: Int ->
        println("in lambda function")
        no1*no2
    }

    println("result : ${some(10, 20)}")
}