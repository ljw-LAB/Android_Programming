package chap02.section2

fun main()
{
    val num = 60

    if(num is Int)
    {
        print(num)
    }
    else if(num !is Int)
    {
        print("Not a Int")
    }
}
