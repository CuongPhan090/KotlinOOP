package Assignment1

import java.util.*

/*
1) Write a program to input a year and check whether it is leap year or not.
 */

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter a year: ")
    val year = scanner.nextInt()
    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
        println("$year is a leap year")
    } else {
        println("$year is not a leap year")
    }
}