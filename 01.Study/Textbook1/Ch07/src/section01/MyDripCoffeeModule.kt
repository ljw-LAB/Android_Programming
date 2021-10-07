package section01.coffeeMaker

//import section01.CoffeeModule
//import section01.EletricHeater

class MyDripCoffeeModule : CoffeeModule {
    companion object
    {
        val eletricHeater : EletricHeater by lazy{
            EletricHeater()
        }
    }

    private val _thermosiphon : Thermosiphon by lazy {
        Thermosiphon(eletricHeater)
    }

    override fun getThermosiphon(): Thermosiphon = _thermosiphon
}