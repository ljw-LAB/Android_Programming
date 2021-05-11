package com.example.myapplication.Kotlin

fun first()
{
    val ArrayList = mutableListOf<Int>(0)
    val ArrayListed = mutableListOf<Int>(0)

    for (i in 1..9)
    {
        ArrayList.add(index = i, element = i)
    }


    println()
    println(ArrayList)

    for (i in 0..9)
    {
        ArrayListed.add(index = i, element = ArrayList[i])

        if( (ArrayListed[i]%2) == 0)
        {
            println("True " + ArrayListed[i])
        }
        else
        {
            println("False " + ArrayListed[i])
        }
    }
}

fun second(score: Int): Char
{
    if(score >= 80 && score <= 90)
    {
        return 'A'
    }
    else if(score >= 70 && score <= 79)
    {
        return 'B'
    }
    if(score >=60 && score <= 69)
    {
        return 'C'
    }
    else
    {
        return 'F'
    }
}

fun third(number: Int): Int
{
    var temp_10 = number/10
    var temp_1 = number%10

    return temp_10 + temp_1
}

fun gugudan()
{
    for (i in 1..9)
    {
        for(j in 1..9)
        {
            println("" + i + "x" + j + "=" + i*j)
        }
    }
}
fun main(array: Array<String>)
{
    first()
    println(second(80))
    println(third(89))
    gugudan()
}

