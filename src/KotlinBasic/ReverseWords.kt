package Assignment1

import java.util.Scanner

// 15) Program to reverse words in given string.
fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter a string: ")
    val str = scanner.nextLine()
    val wordList = str.split(" ")
    var reverseList = Array<String> (wordList.size) {""}
    for (i in wordList.indices) {
        var reverseWord = ""
        for (j in wordList[i].length-1 downTo 0) {
            reverseWord += wordList[i][j]
        }
        reverseList[i] = reverseWord
    }
    print("The reversed string is: ")
    reverseList.forEach{
        print("$it ")
    }
}