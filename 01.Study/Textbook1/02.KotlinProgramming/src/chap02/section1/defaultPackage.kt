package chap02.section1

//import com.example.ljwlab.Person // ex2)
//import kotlin.math.PI // ex1)
//import kotlin.math.abs // ex1)
import com.example.ljwlab.Person as User

fun main()
{
    //val intro: String = "안녕하세요!" // ex1)
    //val num : Int = 20 // ex1)
    //val user1 = Person("Kildong", 30) // ex2)
    val user1 = User("Kildong", 30)
    val user2 = Person("A123","Kildong")

    println(user1.name)
    println(user1.age)

    println(user2.id)
    println(user2.name)

    //println(PI) // ex1)
    //println(abs(-12.6)) // ex1)
    //println("intro $intro, num : $num")  // ex1)

    //println(user1.name) // ex2)
    //println(user1.age) // ex2)
}

class Person(val id : String, val name : String)