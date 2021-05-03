package com.example.myapplication.Kotlin

fun plusThree(first: Int, second: Int, third: Int): Int {
    return first + second + third
}

fun minusThree(first : Int, second : Int, third : Int) = first - second - third

fun multiplyThree(first : Int = 1, second : Int = 1, third : Int = 1) : Int {
    return first*second*third
}

fun  main(array: Array<String>){
    val result = plusThree(first = 1, second= 2, third= 3)
    println(result)
}