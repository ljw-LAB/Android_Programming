package com.example.ex03_2

fun main()
{
    var list = listOf<Int>(10, 20 ,30 )
    println(
        """
            list size : ${list.size}
            list size : ${list[0]}, ${list.get(1)}, ${list.get(2)}
            """.trimIndent()
    )

    var mutableList = mutableListOf<Int>(10, 20, 30)
    mutableList.add(3, 40)
    mutableList.set(0, 50)
    println(
        """
            mutableList  size : ${mutableList.size}
            mutableList size : ${mutableList[0]}, ${mutableList.get(1)}, 
                        ${mutableList.get(2)}, ${mutableList.get(3)}
            """.trimIndent()
    )
}