package Assignment1

import java.util.*

/*
4) Write a program to input a number n and display first n terms of Fibonacci series.
 E.g. if n = 8 then output should be 0 1 1 2 3 5 8 13.
 */

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter a number: ")
    val number = scanner.nextInt()
    println("Displaying $number terms of Fibonacci series")
    if (number == 1) {
        println("0")
    } else {
        print("0 1 ")
        var i = 0
        var j = 1
        var current : Int
        for (counter in 3..number) {
            current = i + j
            print("$current ")
            i = j
            j = current
        }
    }
}

