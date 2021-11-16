package com.example.ex05_1

//fun some(no1: Int, no2: Int) : Int{
//    return no1 + no2
//}

//val some : (Int, Int) -> Int = {no1 : Int, no2 : Int -> no1 + no2}

//typealias MyInt = Int
//fun main()
//{
//    val data1 : Int = 10
//    val data2 : MyInt = 10
//}

typealias MyFuncType = (Int, Int) -> Boolean

fun main()
{
//    val someFun : MyFuncType = {no1 : Int, no2 : Int ->
//        no1 > no2
//    }

//    val someFun : MyFuncType = {no1, no2 ->
//        no1 > no2
//    }

    val someFun = {no1 : Int, no2 : Int ->
        no1 > no2
    }

    println(someFun(10, 20))
    println(someFun(20, 10))
}
