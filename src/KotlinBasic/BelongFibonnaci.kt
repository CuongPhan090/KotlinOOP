package Assignment1

import java.util.Scanner
import kotlin.system.exitProcess

/*
5) Write a program to input a number and check whether that number belongs to Fibonacci series.
 */

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter a number: ")
    val number = scanner.nextInt()
    if (number == 0 || number == 1) {
        println("$number belongs to Fibonacci Series")
    } else {
        var i = 0
        var j = 1
        var current = i + j
        while (current <= number) {
            current = i + j
            if (number == current) {
                println("$number belongs to Fibonacci Series")
                exitProcess(0)
            }
            i = j
            j = current
        }
        println("$number does not belong to Fibonacci Series")
    }
}