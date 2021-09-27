package section4.personthis

open class  Person{

    constructor(firstName : String){
        println("[Person] firstname : $firstName")
    }

    constructor(firstName : String, age : Int){
        println("[Person] firstname : $firstName, $age")
    }
}

class Developer :Person
{
    constructor(firstName : String) : this(firstName, 10){
        println("[Developer] : $firstName")
    }

    constructor(firstName : String, age : Int) : super(firstName, age){
        println("[Developer] : $firstName, $age")
    }
}


fun main()
{
    val sean = Developer("Sean")
}
