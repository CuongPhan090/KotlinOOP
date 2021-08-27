package Assignment1
import java.util.Scanner
/*
9) Program to count frequency of each element in array i.e.
    count number of occurrence of each array element in the integer array
 */

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter the size of the array: ")
    val n = scanner.nextInt()
    val arr = Array<Int> (n) {0}
    var uniqueNumbers = HashMap<Int, Int> ()

    for (i in 0 until n) {
        print("arr[$i]=")
        arr[i] = scanner.nextInt()
    }

    arr.forEach {
        val frequency : Int? = uniqueNumbers[it]
        if (frequency == null) {
            uniqueNumbers[it] = 1
        } else {
            uniqueNumbers[it] = frequency + 1
        }
    }

    uniqueNumbers.forEach{ key, value ->
        println("$key appears $value times")
    }
}
