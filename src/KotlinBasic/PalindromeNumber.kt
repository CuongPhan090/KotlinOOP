package Assignment1
import java.util.Scanner
/*
3) Write a program to input a number and check whether it is Palindrome number or not.
 Number is said to be Palindrome number if number and its reverse of the number is same.
 Example: 1771 is Palindrome number because its reverse number is 1771 itself.
 */
fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter a number: ")
    val number = scanner.nextInt()
    var temp = number
    var reverse = 0

    while (temp != 0)
    {
        val d = temp % 10
        reverse = reverse * 10 + d
        temp /= 10
    }

    if (reverse == number) {
        println("$number is a palindrome")
    } else {
        println("$number is not a palindrome")
    }
}