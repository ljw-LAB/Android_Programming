package com.example.myapplication.Kotlin

// 3) TV클래스
// - on/off 기능
// - 채널을 돌리는 기능
// - 초기 채널은 (S사 M사 K사 3개)

fun main(array: Array<String>)
{
    val channels = listOf<String>("K","M","S")
    //val tv = TV(listOf<String>("K", "M", "S"))
    val tv = TV(channels)
    tv.switch()
    println(tv.onOrOff)
    tv.switch()
    println(tv.onOrOff)

//    tv.channelUp()
//    println(tv.checkCurrentChannel())
//    tv.channelDown()
//    println(tv.checkCurrentChannel())
    tv.channelUp()
    tv.channelUp()
    tv.channelUp()
    tv.channelUp()
    println(tv.checkCurrentChannel())


}

class TV(val channels : List<String>)
{
    var onOrOff : Boolean = false
    var currentChannelNumber = 0
        set(value) { //호출될때
            field = value
            if( field > 2)
            {
                field = 0
            }
            else if(field < 0)
            {
                field = 2
            }
            //println(value)
        }
        get()
        { //반환될때
            println("호출되었습니다")
            return field
            return  field + 1
        }

    fun switch()
    {
        onOrOff = !onOrOff
    }

    fun checkCurrentChannel() : String
    {
        return channels[currentChannelNumber]
    }

    fun channelUp()
    {
        currentChannelNumber = currentChannelNumber +1
//        channels.forEachIndexed { index, value ->
//            if(currentChannelNumber == index)
//            {
//                currentChannelNumber = currentChannelNumber +1
//                return
//            }
//        }
    }

    fun channelDown()
    {
        currentChannelNumber = currentChannelNumber -1
//        channels.forEachIndexed { index, value ->
//            if (currentChannelNumber == index) {
//                currentChannelNumber = currentChannelNumber - 1
//                return
//            }
//        }
    }

}
