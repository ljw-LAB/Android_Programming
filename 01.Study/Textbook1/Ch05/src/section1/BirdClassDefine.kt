package section1

class Bird{ // 1. 클래스 정의

    //2. 프로퍼티(속성(변수)) 정의
    var name : String = "mybird"
    var wing : Int = 2
    var beak : String = "short"
    var color : String = "blue"

    //3. 메서드(함수) 정의
    fun fly() = println("Fly wing : $wing")
    fun sing(vol : Int) = println("Sing vol : $vol")

}

fun main()
{
    val coco = Bird()
    coco.color = "blue"

    println("coco.color : ${coco.color}")
    coco.fly()
    coco.sing(3)
}