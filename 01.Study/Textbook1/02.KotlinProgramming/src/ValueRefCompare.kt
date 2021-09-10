package chap02.section2

fun main()
{
    val a : Int = 128
    val b = a
    println(a === b)

    val c: Int? = a
    val d: Int? = a
    val e: Int? = c

    println(c == d)
    println(c === d) // c와 d의 주소는 같지 않으므로
    println(c === e) // c와 e의 주소는 같으므로
}
