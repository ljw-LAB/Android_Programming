package section02

fun main()
{
    val numbers = arrayOf(1, 2, 3)
    val strs = arrayOf("one", "two", "three")
    val simpleArray = arrayOf(numbers, strs)
    simpleArray.forEach { println(it) }

    val flattemSimpleArray = simpleArray.flatten()
    println(flattemSimpleArray)
}