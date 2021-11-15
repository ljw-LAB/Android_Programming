package com.example.ex04_2_02

open class Super {
    open var someData = 10
    open fun someFunc()
    {
        println("i am super class function : $someData")
    }
}

class Sub : Super()
{
    override var someData = 20
    override fun someFunc() {
        println("i am sub class function : $someData")
    }
}

fun main()
{
    val obj = Sub()
    obj.someFunc()
}
