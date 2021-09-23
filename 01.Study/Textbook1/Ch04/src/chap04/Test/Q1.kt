package chap04.Test

fun main()
{
    var str1: String? = "Hello"
    var len = if(str1 == null) {-1} else {str1.length}
}
