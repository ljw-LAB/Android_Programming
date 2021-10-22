package section01

fun main()
{
    data class  User(val name : String, var skills : String, var email : String? = null)
    val user = User("Kildong", "default")

    val result = with(user)
    {
        skills = "Kotlin"
        email = "Kildong@example.com"
    }
    println(user)
    println("result : $result")
}