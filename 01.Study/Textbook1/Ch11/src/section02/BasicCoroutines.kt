package section02

//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
import kotlinx.coroutines.*

fun main()
{
    GlobalScope.launch {
        delay(1000L)
        println("World!")
        doSomething()

    }

    //doSomething() 메인 스레드에서는 사용 할 수 없음. 에러남

    println("Hello")
    Thread.sleep(2000L)
}

suspend fun doSomething()
{
    println("Do something!")
}
