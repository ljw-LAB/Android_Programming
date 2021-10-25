package section03

import java.io.FileReader

fun main()
{
    val path = "D:\\test\\OVer the Rainbow.txt"

    try {
        val read = FileReader(path)
        println(read.readText())
    }
    catch (e: Exception)
    {
        println(e.message)
    }
}