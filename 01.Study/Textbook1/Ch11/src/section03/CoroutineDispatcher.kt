package section03

import kotlinx.coroutines.*

fun main() = runBlocking {
    val jobs = arrayListOf<Job>()
    jobs += launch(Dispatchers.Unconfined)
    {
        println("Unconfined :\t\t ${java.lang.Thread.currentThread().name}")
    }
    jobs += launch(coroutineContext)
    {
        println("coroutineContext :\t ${java.lang.Thread.currentThread().name}")
    }
    jobs += launch(Dispatchers.Default)
    {
        println("Default :\t\t ${java.lang.Thread.currentThread().name}")
    }
    jobs += launch(Dispatchers.IO)
    {
        println("IO : \t\t ${java.lang.Thread.currentThread().name}")
    }
    jobs += launch{
        println("main runBlocking : ${java.lang.Thread.currentThread().name}")
    }
    jobs += launch(newSingleThreadContext("MyThread"))
    {
        println("MyThread :\t\t ${java.lang.Thread.currentThread().name}")
    }

    jobs.forEach { it.join() }
}

