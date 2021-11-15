package com.example.ex04_3

//val obj = object {
//    var data = 10
//    fun some()
//    {
//        println("data : $data")
//    }
//
//}
//
//fun main()
//{
//    // obj.data = 20 // error
//    // obj.some()    // error
//}

open class Super{
    open var data = 10
    open fun some(){
        println("i am super some(): $data")
    }
}

val obj = object :  Super()
{
    override var data = 20
    override fun some()
    {
        println("i am object some(): $data")
    }
}

fun main()
{
    obj.data = 30
    obj.some()
}
