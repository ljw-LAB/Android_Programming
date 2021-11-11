package com.example.ex03_2

fun main()
{
    fun some(data1 : Int, data2 : Int = 10 ) : Int
    {
        return data1 * data2
    }
    println(some(10))
    println(some(10, 20))

}