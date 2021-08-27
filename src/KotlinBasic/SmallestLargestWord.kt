package Assignment1
import java.util.*

// 14) Program to find smallest and largest word in the string

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter a string: ")
    val str = scanner.nextLine()
    var smallestWord = ""
    var largestWord = ""
    val wordArray = str.split(" ")
    Collections.sort(wordArray)
    println("The smallest word: ${wordArray[0]}")
    println("The largest word: ${wordArray[wordArray.size-1]}")
}