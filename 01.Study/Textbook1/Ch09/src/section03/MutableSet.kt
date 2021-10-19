package section03

fun main()
{
    val animals = mutableSetOf("Lion", "Dog", "Cat", "Python", "Hippo")
    println(animals)

    animals.add("Dog")
    println(animals)

    animals.remove("Python")
    println(animals)
}