package Assignment1
import java.util.Scanner

// 16) Program to input two string A and B. Check if B is substring of A or not.

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter string A: ")
    val strA = scanner.nextLine()
    print("Enter string B: ")
    val strB = scanner.nextLine()
    var isSubstring = false

    for (i in strA.indices) {
        if (strA[i] == strB[0]) {
            for (j in 1 until strB.length) {
                try {
                    if (strA[i + j] != strB[j]) {
                        isSubstring = false
                        break
                    }
                } catch(e : StringIndexOutOfBoundsException) {
                    isSubstring = false
                    break
                }
                isSubstring = true
            }
        }
    }

    if (isSubstring) {
        println("$strB is a substring of $strA")
    } else {
        println("$strB is not a substring of $strA")
    }
}