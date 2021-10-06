package section01

import section01.coffeeMaker.Heater

class EletricHeater (var heating: Boolean = false) : Heater {

    override fun on() {
        println("[ElectricHeater]heating...")
        heating = true
    }

    override fun off() {
        heating = false
    }

    override fun isHot(): Boolean = heating
}