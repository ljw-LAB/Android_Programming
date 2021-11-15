package com.example.ex04_1

//class User {
//    var name = "kkang"
//    constructor(name : String){
//        this.name = name
//    }
//    fun someFun()
//    {
//        println("name : $name")
//    }
//    class SomeClass{}
//}

//class User(name : String, count: Int)
//{
//    init {
//        println("i am init...")
//    }
//}

//class User(name : String, count : Int)
//{
////    init {
////        println("name : $name, count : $count")
////    }
////    fun someFunc()
////    {
////        println("name : $name, count : $count")
////    } //error
//
//    var name : String
//    var count : Int
//
//    init {
//        this.name = name
//        this.count = count
//    }
//
//    fun someFunc()
//    {
//        println("name : $name, count : $count")
//    }
//}

//class User(val name : String, val count : Int)
//{
////    init {
////        println("name : $name, count : $count")
////    }
//    fun someFunc(){
//        println("name : $name, count : $count")
//    }
//
//}

//class  User{
//
//    constructor(name : String)
//    {
//        println("constructor(name : String) call...")
//    }
//    constructor(name : String, count : Int)
//    {
//        println("constructor(name : String, count : Int) call...")
//    }
//}

class User(name : String)
{
//    constructor(name: String, count : Int){
//
//    } // error
    constructor(name : String, count : Int) : this(name)
    {

    }
    constructor(name : String, count : Int, email : String) : this(name, count)
    {

    }
}

fun main()
{
//    val user = User("kim")
//    user.someFun()

//    val user = User("kkang", 10)
//    val user = User("kkang", 10)
//    user.someFunc()

//    val user1 = User("kkang")
//    val user2 = User("kkang", 10)
    val user = User("kkang", 10, "a@a.com")
}
