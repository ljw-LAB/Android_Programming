package section5.privatetest

private class PrivateClass
{
    private var i = 1
    private  fun privateFunc(){
        i +=1
    }
    fun access()
    {
        privateFunc()
    }
}

class OtherClass{
    //val opc = PrivateClass()
    fun test()
    {
        val pc = PrivateClass()
    }
}

fun main()
{
    val pc = PrivateClass()
}

fun TopFunction()
{
    val tpc = PrivateClass()
}