package com.example.myapplication.Kotlin

fun main(args:Array<String>)
{
    val value : Int? = null
    
    when (value)
    {
        null -> println("value is null")
        else -> println("value is not null")
    }

    val value2 : Boolean? = null
    
    //when 구문은 조건으로 가지는 값이 모든 경우에 대응 해주는 것이 좋다.
    when (value2)
    {
        true -> println("value is null")
        false -> println("value is not null")
        null -> println("value is null")
    }
    // 값을 리턴하는 when 구문의 경우 반드시 값을 리턴해야 한다.
    val value3 = when(value2){

        true->1
        false->3
        else->4
    }
    // when의 다양한 조건(1)
    val value4 : Int = 10
    when(value4){
        is Int-> println("value is int")
        else -> println("value4 is not int")
    }

    //when의 다양한 조건식(2)
    val value5 : Int = 70
    when(value5){
        in 60..70->println("value is 60~70")
        in 70..80->println("value is 70~80")
        in 80..90->println("value is 80~90")
    }
}