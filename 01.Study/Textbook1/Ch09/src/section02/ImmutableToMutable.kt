package section02

fun main()
{
    val names : List<String> = listOf("one", "two", "three")
    val mutableNames = names.toMutableList()
    mutableNames.add("four")
    println(mutableNames)
}
