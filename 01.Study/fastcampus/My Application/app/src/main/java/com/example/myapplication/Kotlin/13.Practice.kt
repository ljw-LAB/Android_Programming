package com.example.myapplication.Kotlin

fun main(args:Array<String>)
{
    val array = arrayOf<Int>(1, 2, 3)

    //get, set

    val number = array.get(0)
    println(number)
    //val number1 = array.get(100) // 인덱스에 주의해야 한다

    array.set(0, 100)
    val number2 =array.get(0)
    println(number2)

   // array.set(100, 100) Index값을 초과하므로 동작 x

    //Array의 Bounds
    // -처음 만들때 결정 된다

    // Array를 만드는 방법(3)
    val a1 = intArrayOf(1, 2, 3)
    val a2 = charArrayOf('b', 'b') // char -> '', string->""
    val a3 = doubleArrayOf(1.2, 100.345)
    val a4 = booleanArrayOf(true, false, true)

    // Array를 만드는 방법(4)
    var a5 = Array(10, {0}) // lambda를 활용한 방법
    var a6 = Array(5, {1;2;3;4;5})
}