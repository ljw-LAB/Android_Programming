package section02

val fibonacciSeq = sequence{
    var a = 0
    var b = 1

    yield(1)

    while(true)
    {
        yield(a + b)
        val tmp = a + b
        a = b
        b = tmp
    }
}

val seq = sequence{
    val start = 0
    yield(start)
    yieldAll(1..5 step 2)
    yieldAll(generateSequence(8) {it * 3} )
}

fun main()
{
    println(seq.take(7).toList())
    println(fibonacciSeq.take(8).toList())

    val saved = fibonacciSeq.iterator()

    println("${saved.next()}, ${saved.next()}, ${saved.next()}")
}