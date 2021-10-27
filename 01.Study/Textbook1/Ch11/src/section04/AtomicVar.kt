package section04

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

var counter = 0

suspend fun massiveRun(action : suspend() -> Unit)
{
    val n = 1000
    val k = 1000
    val time = measureTimeMillis {
        val jobs = List(n)
        {
            GlobalScope.launch {
                repeat(k){action()}
            }
        }
        jobs.forEach { it.join() }
    }
    println("Completed ${n*k} actions in $time ms")
}

fun main() = runBlocking {
    massiveRun {
        counter++
    }
    println("Counter = ${section04.counter}")
}