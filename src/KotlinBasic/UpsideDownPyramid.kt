package Assignment1

import java.util.Scanner

/*
6) Program to print following pattern for given lines n
* * * * *
* * * *
* * *
* *
*
 */
fun main () {
    val scanner = Scanner(System.`in`)
    print("Enter a number: ")
    val number = scanner.nextInt()
    for (j in number-1 downTo 0) {
        for (i in 0..j) {
            print("* ")
        }
        println()
    }
}