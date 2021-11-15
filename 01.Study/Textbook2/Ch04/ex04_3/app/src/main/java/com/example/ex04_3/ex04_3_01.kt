package com.example.ex04_3

//class NodDataClass(val name : String, val email : String, val age : Int)
//
//data class DataClass(val name : String, val email : String, val age : Int)
//
//fun main()
//{
//    val non1 = NodDataClass("kkang", "a@a.com", 10)
//    val non2 = NodDataClass("kkang", "a@a.com", 10)
//
//    val data1 = DataClass("kkang","a@a.com", 10)
//    val data2 = DataClass("kkang","a@a.com", 10)
//
//    println("non data class equals : ${non1.equals(non2)}")
//    println("non data class equals : ${data1.equals(data2)}")
//
//}

data class DataClass(val name : String, val email : String, val age : Int)
{
    lateinit var address : String
    constructor(name : String, email: String, age: Int, address : String) :
            this(name, email ,age) {
            this.address = address

    }
}

fun main()
{
    val obj1 = DataClass("kkang", "a@a.com", 10, "seoul")
    val obj2 = DataClass("kkang", "a@a.com", 10, "busan")
    println("obj1.equals(obj2) : ${obj1.equals(obj2)}")
}
