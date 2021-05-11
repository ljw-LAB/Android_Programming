package com.example.myapplication.Kotlin

fun first_1()
{
    val list1 = MutableList( 9, {0})
    val list2 = MutableList(9, {true})

    for(i in 0..8)
    {
        list1[i] = i + 1
    }
    println(list1)
    list1.forEachIndexed{index, value ->
        if(value % 2 ==0)
        {
            list2[index] = true
        }
        else
        {
            list2[index] = false
        }
    }
    println(list2)
//    for(i in 1..9)
//    {
//        list1[i-1] = i
//    }
}

fun second_1(score : Int) : String
{
    when(score)
    {
        in 90..100 ->{return "A"}
        in 80..89 ->{return "B"}
        in 70..79 ->{return "C"}
        else ->{return  "F"}
    }
}

fun third_1(number: Int): Int
{
    val a: Int = number/10
    var b: Int = number%10

    return a + b
}

fun gugudan_1()
{
    for (i in 1..9)
    {
        for(j in 1..9)
        {
            println("$i x $j = ${i*j}")
        }
    }
}

fun main(array: Array<String>)
{
    first_1()
    println(second_1(80))
    println(third_1(89))
   gugudan_1()
}