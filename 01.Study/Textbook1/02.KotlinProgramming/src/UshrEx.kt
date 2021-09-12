package chap02.section2

fun main()
{
    val number1 = 5
    val number2 = -5

    println(number1 shr 1)  // 0000 0101 -> 0000 0010
    println(number1 ushr 1) // 0000 0101 -> 0000 0010
    println(number2 shr 1) // 1111 1111 1111 1011 -> 1 0111 1111 1111 1101 -3 음수는 모두 1로 채워져 있나?
    println(number2 ushr 1)

}
