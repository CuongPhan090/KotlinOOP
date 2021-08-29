package TechnicalInterview
// Program to input two strings and check if they are Anagram strings
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter string A: ")
    val strA = scanner.nextLine()
    print("Enter string B: ")
    val strB = scanner.nextLine()

    println("String $strA and String $strB: ${isAnagram(strA, strB)}")
}

 fun isAnagram(strA: String, strB: String): Boolean {
    val charFrequencyA = HashMap<Char, Int>()
    val charFrequencyB = HashMap<Char, Int>()

    strA.forEach{
        charFrequencyA[it] = charFrequencyA.getOrDefault(it, 0) + 1
    }

    strB.forEach {
        charFrequencyB[it] = charFrequencyB.getOrDefault(it, 0) + 1
    }

    for (key in charFrequencyA.keys) {
        if (charFrequencyA[key] != charFrequencyB[key])
            return false
    }
    return true
}

