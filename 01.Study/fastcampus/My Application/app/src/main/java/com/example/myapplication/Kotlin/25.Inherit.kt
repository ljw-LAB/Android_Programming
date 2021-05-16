package com.example.myapplication.Kotlin

// 두번까지는 봐준다
// 두번 이상이 넘어가면 리팩토링 해라

// 25. 상속
// 부모로부터 설명서를 물려받는다!

fun main(args: Array<String>)
{
    val suprerCar100 : SuperCar100 = SuperCar100()
    suprerCar100.drive()
    println(suprerCar100.drive())
//    suprerCar100.stop()
//
//    val bus100 : Bus100 = Bus100()
//    bus100.drive()
//    bus100.stop()
}

// 부모 : Car100
// 자식 : SuperCar100, Bus100
open class Car100() // 기본적으로 클래스, 함수 앞에는 private 붙어 있음, 외부에서 접급 할수 있도록 open 키워드 사용
{
    open fun drive() : String
    {
        //println("달린다")
        return "달린다"
    }

    fun stop()
    {

    }

}

class SuperCar100() : Car100()
{
    override fun drive() :String
    {
        //println("빨리 달린다")
        val run = super.drive()//부모의 드라이브 호출
        return "빨리 $run"
    }
}

class Bus100() : Car100()
{

}
