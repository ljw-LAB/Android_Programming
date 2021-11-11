package com.example.ex03_2

fun main()
{
    val data1 : IntArray = IntArray(3, {0})
    val data2 : BooleanArray = BooleanArray(3, {false})

    val data3 = arrayOf<Int>(10, 20 ,30)

    val data4 = intArrayOf(10, 20 ,30 )
    val data5 = booleanArrayOf(true, false, true)

    println(
        """
            array size : ${data1.size}
            array data : ${data1[0]}, ${data1[1]}, ${data1.get(2)}
            
            array size : ${data2.size}
            array data : ${data2[0]}, ${data2[1]}, ${data2.get(2)}
            
            array size : ${data3.size}
            array data : ${data3[0]}, ${data3[1]}, ${data3.get(2)}
   
            array size : ${data4.size}
            array data : ${data4[0]}, ${data4[1]}, ${data4.get(2)}
   
            array size : ${data5.size}
            array data : ${data5[0]}, ${data5[1]}, ${data5.get(2)}
   
        """.trimIndent()
    )

}
