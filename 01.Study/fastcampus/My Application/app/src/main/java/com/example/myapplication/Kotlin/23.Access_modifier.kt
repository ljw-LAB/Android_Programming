package com.example.myapplication.Kotlin

import com.example.myapplication.R

// 23. 접근 제어자

fun main(array: Array<String>)
{
    val testAccess : TestAccess = TestAccess("아무개")
    testAccess.test()
    println(testAccess.name)
    testAccess.name ="아무개 투"
    println(testAccess.name)

    val reward : Reward = Reward()
    reward.rewardAmount = 2000

    val runningCar : RunningCar = RunningCar()
    runningCar.runFast()
    // runningCar.run() 외부에서 접근 할 수 없기 때문에 에러
    // Private 키워드는 함수, 변수는 외부에서 사용 할 수 없다
}

class Reward()
{
    var rewardAmount : Int = 1000
}

class  TestAccess
{
    var name : String = "홍길동"
    constructor(name : String)
    {
        this.name = name
    }

    fun test()
    {
        println("테스트")
    }
    
}

class RunningCar()
{
    fun runFast()
    {
        run()
    }

    private fun run()
    {

    }
}
