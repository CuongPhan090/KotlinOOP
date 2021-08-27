package Assignment1
// 10) Program to find the first pair of elements from array whose sum is zero
import java.util.Scanner
import kotlin.system.exitProcess

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter the array size: ")
    val size = scanner.nextInt()
    val arr = Array<Int> (size) {0}
    print("Enter the array elements: ")
    for (i in arr.indices) {
        arr[i] = scanner.nextInt()
    }

    for (i in arr.indices) {
        for (j in arr.indices) {
            if (arr[i] + arr[j] == 0) {
                println("Found a pair of elements from array whose sum is zero!")
                println("It is located at index $i and $j, with corresponding value ${arr[i]} and ${arr[j]}")
                exitProcess(0)
            }
        }
    }

    println("Found a pair of elements from array whose sum is zero!")
}