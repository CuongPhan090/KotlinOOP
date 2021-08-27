package Assignment1
import java.util.*

/*
8) Program to merge two sorted array in to third array in such a way that merged array is sorted.
Example:
First Array: [ 30, 50, 77, 200, 350, 461 ]
Second Array: [ 10, 25, 60, 72, 300 ]
Merged Array: [ 10, 25, 30, 50, 60, 72, 77, 200, 300, 350, 461 ]
 */

fun main () {
    val scanner = Scanner(System.`in`)
    print("Enter the first array size: ")
    val firstArraySize = scanner.nextInt()
    print("Enter the second array size: ")
    val secondArraySize = scanner.nextInt()

    // Initialize 2 arrays
    val firstArray = Array<Int> (firstArraySize,) {0}
    val secondArray = Array<Int> (secondArraySize,) {0}

    // Populate 2 arrays
    for (i in firstArray.indices) {
        print("firstArray[$i]=")
        firstArray[i] = scanner.nextInt()
    }

    for (i in secondArray.indices) {
        print("secondArray[$i]=")
        secondArray[i] = scanner.nextInt()
    }

    // Merge 2 arrays into 1 array
    val thirdArray = Array<Int> (firstArraySize + secondArraySize) {0}
    val smallerSize = if (firstArraySize < secondArraySize) firstArraySize
    else secondArraySize

    var counter = 0
    for (i in 0 until smallerSize) {
        thirdArray[counter] = firstArray[i]
        counter++
        thirdArray[counter] = secondArray[i]
        counter++
    }

    var newCounter = smallerSize * 2
    if (firstArraySize > smallerSize) {
        for (i in smallerSize until firstArraySize) {
            thirdArray[newCounter] = firstArray[i]
            newCounter++
        }
    } else if (secondArraySize > smallerSize){
        for (i in smallerSize until secondArraySize) {
            thirdArray[newCounter] = secondArray[i]
            newCounter++
        }
    }

    println("Newly created array: ")
    thirdArray.forEach{
        print("$it ")
    }
    println()

    println("Sorted third array: ")
    thirdArray.sort()
    thirdArray.forEach{
        print("$it ")
    }
}
