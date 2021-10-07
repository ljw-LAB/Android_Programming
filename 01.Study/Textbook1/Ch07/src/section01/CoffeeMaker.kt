package section01.coffeeMaker

import section01.coffeeMaker.MyDripCoffeeModule
import section01.coffeeMaker.Thermosiphon

class CoffeeMaker(val coffeeModule: CoffeeModule) {
    fun brew()
    {
        val theSiphon : Thermosiphon = coffeeModule.getThermosiphon()
        theSiphon.on()
        theSiphon.pump()
        println("Coffee, here! Enjoy!~")
        theSiphon.off()
    }
}

fun main()
{
    val coffeeMaker = CoffeeMaker(MyDripCoffeeModule())
    coffeeMaker.brew()
}
