package section02

fun main()
{
    val stringList : ArrayList<String> = arrayListOf<String>("Hello", "Kotlin", "Wow")
    stringList.add("Java")
    stringList.remove("Hello")
    println(stringList)
}
