package com.example.ex04_2

//open class Super{
//
//}
//
//class Sub: Super()
//{
//
//}

//open class Super(name : String)
//{
//
//}
//
//class Sub(name: String) : Super(name)
//{
//
//}

//open class Super(name : String)
//{
//    class Sub : Super {
//        constructor(name : String) : super(name)
//        {
//
//        }
//    }
//}

open class Super{
    var superData = 10
    fun superFun()
    {
        println("i am superFun : $superData")
    }
}

class Sub: Super()

fun main()
{
    val obj = Sub()
    obj.superData = 20
    obj.superFun()
}