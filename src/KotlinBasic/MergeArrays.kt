package Assignment1
import java.util.Scanner
/*
7) Program to merge two array elements into third array.
Example:
First array: [ 100, 300, 400, 200, 700, 200 ]
Second array: [ 15, 70, 34, 22 ]
Merged Array: [ 100, 15, 300, 70, 400, 34, 200, 22, 700, 200 ]
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
}
