package Assignment1

import java.util.Scanner

/*
13) Program to input square matrix and find sum of upper diagonal elements,
lower diagonal elements and diagonal elements

 */
fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter matrix dimension: ")
    val dimension = scanner.nextInt()
    println("Creating a square matrix...")
    val squaredMatrix = Array<Array<Int>> (dimension) {Array<Int> (dimension) { 0 }}
    var sum = 0

    for (i in squaredMatrix.indices) {
        for (j in squaredMatrix.indices) {
            squaredMatrix[i][j] = scanner.nextInt()
        }
    }

    for (i in squaredMatrix.indices) {
        for (j in squaredMatrix.indices) {
            print("${squaredMatrix[i][j]} ")
        }
        println()
    }

    for (i in squaredMatrix.indices) {
        for (j in squaredMatrix.indices) {
            sum += squaredMatrix[i][j]
        }
    }

    println("The sum of the squared matrix: $sum")
}
