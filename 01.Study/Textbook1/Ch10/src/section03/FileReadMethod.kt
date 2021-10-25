package section03

//import java.io.BufferedReader
//import java.io.File
//import java.io.InputStream
//import java.io.InputStreamReader
import java.io.*

fun main()
{
    val path = "D:\\test\\Over the Rainbow.txt"

    val file = File(path)
    val inputStream : InputStream = file.inputStream()
    val inputStreamReader = InputStreamReader(inputStream)

    val sb = StringBuilder()
    var line : String?
    val br = BufferedReader(inputStreamReader)

    try {
        line = br.readLine()
        while (line != null)
        {
            sb.append(line, '\n')
            line = br.readLine()
        }
        println(sb)
    }
    catch (e:Exception)
    {

    }
    finally {
        br.close()
    }

}