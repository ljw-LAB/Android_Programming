package section01

fun main()
{
    val score : Int? = 32

    fun checkSCore()
    {
        if(score != null)
        {
            println("Score : $score")
        }
    }

    fun checkScoreLet()
    {
        score?.let { println("Score : $score") }
        val str = score.let { it.toString() }
        println(str)
    }
    checkSCore()
    checkScoreLet()
}
