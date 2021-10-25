package section03

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

fun main()
{
    val path = "D:\\test\\hello.txt"
    val text = "안녕하세요! Hello World \n"

    try{
        Files.write(Paths.get(path), text.toByteArray(), StandardOpenOption.CREATE)
    }
    catch (e:IOException)
    {

    }
}
