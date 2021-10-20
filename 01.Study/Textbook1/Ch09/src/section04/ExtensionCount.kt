package section04

fun main()
{
    val list = listOf(1, 2, 3, 4, 5, 6)
    val listPair = listOf(Pair("A", 300), Pair("B", 200), Pair("A", 100))
    val map = mapOf(11 to "JAVA", 22 to "Kotlin", 33 to "C++")

    list.forEach{ print("$it")}
    println()
    list.forEachIndexed{ index, value -> println("index[$index] : $value")  }

    val returenedList = list.onEach { print(it) }
    println()
    val returnedMap = map.onEach { println("key : ${it.key}, value : ${it.value}") }
    println("returnedList = $returenedList")
    println("returnedMap = $returnedMap")

    println(list.count { it % 2 ==0 })

    println(list.maxOrNull())
    println(list.minOrNull())
    println("maxBy: " + map.maxByOrNull { it.key })
    println("minBy: " + map.minByOrNull { it.key })

    println(list.fold(4){total, next -> total + next})
    println(list.fold(1){total, next -> total * next})

    println(list.foldRight(4){total, next -> total + next})
    println(list.foldRight(1){total, next -> total * next})

    println(list.reduce{total, next -> total + next})
    println(list.reduceRight{total, next -> total + next})

    println(listPair.sumBy { it.second })

}