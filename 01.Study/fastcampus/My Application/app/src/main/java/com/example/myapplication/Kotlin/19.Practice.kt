package com.example.myapplication.Kotlin

// 1) 사칙 연산을 수행 할 수 있는 클래스

// 2) 은행 계좌 만들기
// - 계좌 생성 기능(이름, 생년월일)
// - 잔고를 확인 하는 기능
// - 출금 기능
// - 예금 기능

// 3) TV클래스
// - on/off 기능
// - 채널을 돌리는 기능
// - 초기 채널은 (S사 M사 K사 3개)

fun main(array: Array<String>)
{
    var test1 : Test1 = Test1(a = 4, b =2)

    println(test1.Plus())
    println(test1.Minus())
    println(test1.Multiply())
    println(test1.Divide())

}

class Test1
{
    var a : Int = 0
    var b : Int = 0

    constructor(a : Int, b : Int)
    {
        this.a = a
        this.b = b
    }
    fun Plus() : Int
    {
        return a+b
    }

    fun Minus() : Int
    {
        return a-b
    }

    fun Multiply() : Int
    {
        return a*b
    }

    fun Divide() : Int
    {
        return a/b
    }
}

class Test2
{
    var name : String = ""
    var birth : String = ""
    var money : Int = 0
    var total : Int = 0

    fun make(name: String, birth : String)
    {
        this.name = name
        this.birth = birth
        println(name)
        println(birth)

    }

    fun Confirm(total : Int) : Int
    {
        this.total = total
        return total
        println(total)
    }

    fun Withdraw(money : Int) : Int
    {
        this.money = money
        this.total = total - money
        return total
        println(money)
        println(total)
    }

    fun Deposit(money: Int) : Int
    {
        this.money = money
        this.total = total + money
        return total
        println(money)
        println(total)
    }
}

class Test3
{

    var channel_1 : Char
    var channel_2 : Char
    var channel_3 : Char
    var On_off : Boolean = false // False Off, True On, 초기상태 Off

    init {
        channel_1 = 'S'
        channel_2 = 'M'
        channel_3 = 'K'

    }
    fun On_Off(On_off: Boolean)
    {
        this.On_off = On_off
    }
    fun Channel_Control()
    {

    }
}