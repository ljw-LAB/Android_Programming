package com.example.myapplication.Kotlin

// 27. Interface
// - 인터페이스는 약속! 인터페이스는 상속이 아닌 구현
// - 생성자가 없다 -> 인스턴스화 시킬 수 없다 -> 설명서가 아니다!
// - 지침서 -> 니가 이것을 구현하고 싶다면 반드시 아래 기능을 구현해라!

// 상속이 만들어낸 특징
// - 자식 클래스는 부모 클래스의 타입이다
// - 부모 클래스는 자식 클래스의 타입이 아니다!
// 인터페이스는 같은 기능을 가지나, 기능마다 세부적인 차이가 있을때 사용, 상속과는 다름

// 상속과 다른점
// - 상속은 조상을 찾아가는 느낌
// - 인터페이스는 종의 특징

fun main(array: Array<String>)
{
    val student_ : Student_ = Student_()
    student_.eat()
    student_.sleep()
}

interface  Person_
{
    fun eat()
    fun sleep()
}

class Student_ : Person_
{
    override fun eat()
    {

    }

    override fun sleep()
    {

    }

}

class SoccerPlayer : Person_
{
    override fun eat()
    {

    }

    override fun sleep()
    {

    }
}

open class Person()
{
    fun eat()
    {

    }
    fun sleep()
    {

    }
}

class Student():Person()
{

}

class Teacher() : Person()
{

}
