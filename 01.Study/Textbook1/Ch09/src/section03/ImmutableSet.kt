package section03

fun main()
{
    val mixedTypesSet = setOf("Hello", 5, "world", 3.14, 'c')
    var intSet : Set<Int> = setOf<Int>(1, 5, 5)

    println(mixedTypesSet)
    println(intSet)
}