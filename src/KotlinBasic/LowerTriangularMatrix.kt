package Assignment1
import java.sql.SQLData
import java.util.Scanner
import kotlin.system.exitProcess

/* 12) Program to input square matrix and check if it is lower triangular
    matrix or not i.e. all upper diagonal elements are 0 or not
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

    for (i in squaredMatrix.indices) {
        for (j in i+1 until squaredMatrix.size) {
            if (squaredMatrix[i][j] != 0) {
                println("This is not an lower triangular matrix")
                exitProcess(0)
            }
        }
    }

    println("This is an lower triangular matrix")


}
