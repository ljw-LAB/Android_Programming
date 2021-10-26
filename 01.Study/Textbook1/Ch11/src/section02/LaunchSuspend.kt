package section02

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun doWork1() : String
{
    delay(1000)
    return "Work1"
}

suspend fun doWork2() : String
{
    delay(3000)
    return "Work2"
}

private fun worksInSerial()
{
    GlobalScope.launch {
        val one = doWork1()
        val two = doWork2()
        println("Kotlin One : $one")
        println("Kotlin Two : $two")

    }
}

fun main()
{
    worksInSerial()
    readLine()
}

