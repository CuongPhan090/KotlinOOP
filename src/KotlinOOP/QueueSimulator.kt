package KotlinOOP
import java.util.Scanner
// Write a program to implement queue data structure
fun main() {
    val customerList = CustomQueue<String>()
    // Testing
    customerList.enqueue("Rock")
    customerList.enqueue("Paper")
    customerList.enqueue("Scissor")
    customerList.printer()
    println(customerList.dequeue())
    println(customerList.peek())
    println(customerList.isEmpty())
    customerList.enqueue("Rock Kid")
    customerList.printer()
    println(customerList.dequeue())
    println(customerList.dequeue())
    println(customerList.dequeue())
    println(customerList.peek())
    println(customerList.isEmpty())
    customerList.printer()

}

class CustomQueue<T>() {
    val arr : ArrayList<T>

    init {
         arr = ArrayList<T>()
    }

    fun printer() {
        println("Queue size: ${size()}")
        arr.forEach{
            print("$it ")
        }
        println()
    }
    fun enqueue(element: T) {
        arr.add(element)
        println("Successfully add $element to the current queue!")
    }

    fun dequeue(): T? {
        return arr.removeFirstOrNull()
    }

    fun isEmpty(): Boolean {
        return arr.size == 0
    }

    fun peek() : T? {
        return arr.firstOrNull()
    }

    fun size() : Int {
        return arr.size
    }
}


