package section04.confinement

import kotlinx.coroutines.*
import section04.massiveRun
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

val counterContext = newSingleThreadContext("CounterContext")
var counter = 0

suspend fun  massiveRun(context : CoroutineContext, action : suspend () -> Unit)
{
    val n = 1000
    val k = 1000

    val time = measureTimeMillis {
        val jobs = List(n)
        {
            GlobalScope.launch(context){
                repeat(k){action}
            }
        }
        jobs.forEach { it.join() }
    }
    println("Completed ${n*k} actions in $time ms")
}

fun main() = runBlocking<Unit> {
    massiveRun{
        withContext(counterContext)
        {
            counter++
        }
    }
    println("Counter = ${section04.confinement.counter}")
}