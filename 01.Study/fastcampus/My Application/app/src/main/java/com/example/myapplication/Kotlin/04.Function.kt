package com.example.myapplication.Kotlin

// 04. Function
// -함수
// -어떤 input을 넣어주면 어떤 output 나오는 것
// - y= x + 2

// = 함수를 선언하는 방법
// fun 함수명(변수명 : 타입, 변수명 : 타입...) : 반환형{
// 함수 내용
// return 반환값
// }

fun plus(first: Int, second: Int): Int
{
    println(first)
    println(second)
    val result : Int = first + second
    println(result)
    return result
}

fun  main(array: Array<String>)
{
    val result = plus(5, 10)
    println(result)

    val result2 = plus(20, 30)
    println(result2)

    val result3 = plus(100, 10)
    println(result3)
}