package section03

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val channel = Channel<Int>(3)
    val sender = launch(coroutineContext)
    {
        repeat(10)
        {
            println("Seconding $it")
            channel.send(it)
        }
    }
    delay(1000)
    sender.cancel()
}