package com.example.ex03_3

//fun main()
//{
//    var sum : Int = 0
//    //for(i in 1..10)
//    //for(i in 1 until  10)
//    //for (i in 2..10 step 2)
//    for (i in 10 downTo 1)
//    {
//        sum += i
//        println("i = $i")
//    }
//    println("sum = $sum")
//}

//fun main()
//{
//    var data = arrayOf<Int>(10, 20 ,30)
//    //for (i in data.indices)
//    //{
//        //print(data[i])
//        //if(i != data.size -1) print(",") //배열 옆에 ,를 붙이기 위함
//
//    //}
//    for ((index, value) in data.withIndex())
//    {
//        print(value)
//        if(index != data.size -1) print(",") //배열 옆에 ,를 붙이기 위함
//    }
//}

fun main()
{
    var x = 0
    var sum1 = 0

    while(x < 10)
    {
        sum1 += ++x
    }
    println(sum1)
}00
