package com.example.ex03_3

fun main()
{
//    var data = 10
//    when(data)
//    {
//        10 -> println("data is 10")
//        20 -> println("data is 20")
//        else ->
//        {
//            println("data is not vaild data")
//        }
//    }

//    var data = "hello"
//    when(data)
//    {
//        "hello" -> println("data is hello")
//        "world" -> println("data is world")
//        else ->
//        {
//            println("data is not valid data")
//        }
//    }

//    var data : Any = 10
//    when(data)
//    {
//        is String -> println("data is String")
//        20, 30 -> println("data is 20 or 30")
//        in 1..10 -> println("data is 1..10")
//        else -> println("data is not valid")
//    }

//    var data = 10
//    when
//    {
//        data <= 0 -> println("data is <= 0")
//        data > 100 -> println("data is > 100")
//        else -> println("data is valid")
//    }

    var data = 10

    val result = when
    {
        data <= 0 -> "data is <= 0"
        data > 100 -> "data is > 100"
        else -> "data is valid"
    }

    println(result)
}