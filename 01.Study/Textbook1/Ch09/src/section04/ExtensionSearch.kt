package section04

fun main()
{
    val list = listOf(1, 2, 3, 4, 5, 6)
    val listPair = listOf(Pair("A", 300), Pair("B", 200), Pair("C", 100), Pair("D", 200))
    val listReaPeated = listOf(2, 2, 3, 4, 5, 5, 6)

    println("elementAt: " + list.elementAt(1))

    println("elementAtOrElse: " + list.elementAtOrElse(10, {2 * it}))

    println("elementAtOrNull: " + list.elementAtOrNull(10))

    println("first : " + listPair.first{ it.second == 200})

    println("last : " + listPair.last{ it.second == 200})

    println("firstOrNull : " + listPair.firstOrNull { it.first == "E" })

    println("firstOrNull : " + listPair.lastOrNull() { it.first == "E" })

    println("indexOf : " + list.indexOf(4))

    println("indexOfFirst : " + list.indexOfFirst { it % 2 == 0 })

    println("lastIndexOf : " + listReaPeated.lastIndexOf(5))

    println("indexOfLast : " + list.indexOfLast { it % 2 == 0 })

    println("single : " + listPair.single{it.second == 100})
    println("singleOrNull : " + listPair.singleOrNull{it.second == 500})

    println("binarySearch : " + list.binarySearch(3))

    println("find : " + list.find { it > 3 })
}
