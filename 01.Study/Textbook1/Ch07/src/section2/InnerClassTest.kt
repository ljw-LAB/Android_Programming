package section2

class Smartphone(val model : String)
{
    private val cpu = "Exynos"

    inner class ExternalStroage(val size : Int)
    {
        fun getInfo() = "${model} : Installed on $cpu with ${size}Gb"
    }
}

fun main()
{
    val mySdcard = Smartphone("S7").ExternalStroage(32)
    println(mySdcard.getInfo())
}
