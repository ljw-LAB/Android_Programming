package section03

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select

fun main() = runBlocking {

    val routine1 = GlobalScope.produce {
        delay(java.util.Random().nextInt(1000).toLong())
        send("A")
    }
    val routine2 = GlobalScope.produce {
        delay(java.util.Random().nextInt(1000).toLong())
        send("B")
    }
    val result = select<String> {
        routine1.onReceive{ result -> result}
        routine2.onReceive{ result -> result}
    }
    println("Result was $result")
}