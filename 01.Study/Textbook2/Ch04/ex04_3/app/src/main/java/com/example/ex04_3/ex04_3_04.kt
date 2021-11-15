package com.example.ex04_3

class MyClass
{
    companion object{
        var data = 10
        fun some()
        {
            println(data)
        }
    }
}

fun main()
{
    val obj = MyClass()
    //obj.data = 20
    //obj.some()
    MyClass.data = 20 // error
    MyClass.some()    // error
}