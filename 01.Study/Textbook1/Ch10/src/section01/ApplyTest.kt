package section01

fun main()
{
    data class Person(var name : String, var skills : String)
    var person = Person("Kildong", "Kotlin")
    person.apply { this.skills = "Swift" }
    println(person)

    val retrunobj = person.apply {
        name = "Sean"
        skills = "Java"
    }

    println(person)
    println(retrunobj)
}
