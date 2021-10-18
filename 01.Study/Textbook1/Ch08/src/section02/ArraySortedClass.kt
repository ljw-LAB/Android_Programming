package section02

data class Product(val name : String, val price : Double)

fun main()
{
    val product = arrayOf(
        Product("Snow Ball", 870.00),
        Product("Smart Phone", 999.00),
        Product("Drone", 240.00),
        Product("Mouse", 333.00),
        Product("KeyBoard", 125.99),
        Product("Monitor", 1500.99),
        Product("Tablet", 512.99))

        product.sortBy { it.price }
        product.forEach { println(it) }
}