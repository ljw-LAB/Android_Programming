package com.example.ex04_2_03

open class Super{
    var publicData = 10
    protected var protectedData = 20
    private var privateData = 30
}

class Sub : Super()
{
    fun subFunc()
    {
        publicData++
        protectedData++
        //privateData++ //error
    }
}

fun main()
{
    val obj = Super()
    obj.publicData++
    //obj.protectedData++ // error
    //obj.privateData //error
}
