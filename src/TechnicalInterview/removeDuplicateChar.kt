package TechnicalInterview
// Program to remove duplicate chars from string. If possible implement using Extension function
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter a string: ")
    val str = scanner.nextLine()
    println(str.removeDuplicate())
}

fun String.removeDuplicate(): StringBuffer{
    val uniqueStr = StringBuffer()
    this.toSet().forEach{
        uniqueStr.append(it)
    }
    return uniqueStr
}