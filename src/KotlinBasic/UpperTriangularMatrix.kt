package Assignment1
import java.util.Scanner
import kotlin.system.exitProcess

/* 11)Program to input square matrix and check if its upper triangular matrix or not i.e.
    all lower diagonal elements are 0 or not
 */

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter matrix dimension: ")
    val dimension = scanner.nextInt()
    println("Creating a square matrix...")
    val squaredMatrix = Array<Array<Int>> (dimension) {Array<Int> (dimension) { 0 }}

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

    for (i in 1 until squaredMatrix.size) {
        for (j in 0 until i) {
            if (squaredMatrix[i][j] != 0) {
                println("This is not an upper triangular matrix")
                exitProcess(0)
            }
        }
    }

    println("This is an upper triangular matrix")


}
