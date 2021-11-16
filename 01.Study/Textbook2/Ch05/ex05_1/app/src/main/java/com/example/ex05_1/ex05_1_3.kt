package com.example.ex05_1

fun hofFun(arg : (Int) -> Boolean) : () -> String{
    val result = if(arg(10)){
        "vaild"
    }
    else
    {
        "invaild"
    }
    return {"hofFun result : $result"}
}

fun main()
{
    val result = hofFun { no -> no > 0 }
    println(result())
}
