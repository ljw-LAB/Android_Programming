package section02

interface Switcher
{
    fun on() : String
}

class Smartphone(val model : String)
{
    private val cpu = "Exynos"

    inner class ExternalStroage(val size : Int)
    {
        fun getInfo() = "${model} : Installed on $cpu with ${size}Gb"
    }

    fun powerOn() : String
    {
        class Led(val color : String)
        {
            fun blink() : String = "Blinking $color on $model"
        }
        val powerStatus = Led("Red")
        val powerSwitch = object  : Switcher {
            override fun on() : String
            {
                return powerStatus.blink( )
            }
        }
        return powerSwitch.on()
    }

}

fun main()
{
    val mySdcard = Smartphone("S7").ExternalStroage(32)
    println(mySdcard.getInfo())

    val myphone = Smartphone("Note9")
    myphone.ExternalStroage(128)
    println(myphone.powerOn())
}
