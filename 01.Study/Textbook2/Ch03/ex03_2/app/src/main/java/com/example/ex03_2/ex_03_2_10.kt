package com.example.ex03_2

fun main()
{
    var map = mapOf<String, String>(Pair("one", "Hello"), "two" to "World")
    println(
        """
            map size : ${map.size}
            map size : ${map.get("one")}, ${map.get("two")}
            """.trimIndent()
    )
}