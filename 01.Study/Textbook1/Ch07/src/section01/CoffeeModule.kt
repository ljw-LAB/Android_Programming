package section01.coffeeMaker

import section01.coffeeMaker.Thermosiphon

interface CoffeeModule {
    fun getThermosiphon() : Thermosiphon
}