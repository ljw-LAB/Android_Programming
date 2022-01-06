import android.util.Log
import java.util.*

//package com.example.lotto_gen

fun main()
{
    val random = Random()
//    val list = mutableListOf<Int>()
//    for( i in 1..6) {
//        println("${random.nextInt(45) + 1}")
//    }
//    while (list.size < 6)
//    {
//        val randomNumber = random.nextInt(45) + 1
//        if(list.contains(randomNumber))
//        {
//            continue
//        }

//        list.add(randomNumber)

//    }
//    println(list)

//    val numberSet = mutableSetOf<Int>()
//    while (numberSet.size < 6)
//    {
//        val randomNumber = random.nextInt(45) + 1
//        numberSet.add(randomNumber)
//    }
//    println(numberSet)

    val list_1 = mutableListOf<Int>().apply {
        //초기화
        for(i in 1 .. 45)
        {
            this.add(i)
        }
    }

    list_1.shuffle() // 1 .. 45까지 순차적인 배열을 섞어주는 함수
    println(list_1.subList(0, 6)) // 0번부터 6까지 사이의 숫자를 지정 (범위 : 1 ~ 5)

}
