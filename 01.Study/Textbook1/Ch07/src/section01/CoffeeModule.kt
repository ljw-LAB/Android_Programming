package section01

import section01.coffeeMaker.Thermosiphon

interface CoffeeModule {
    fun getThermosiphon() : Thermosiphon
}