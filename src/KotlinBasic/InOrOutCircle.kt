package Assignment1

import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

/*
2) Write a program to input co-ordinate of center of circle, length of radius of circle.
 Also input co-ordinate of any point and check whether that point lies inside the circle,
 outside the circle or it lies on circle.
 */
fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter the center of circle x-coordinate: ")
    val centerX = scanner.nextDouble()
    print("Enter the center of circle y-coordinate: ")
    val centerY = scanner.nextDouble()
    print("Enter the circle radius: ")
    val radius = scanner.nextDouble()
    print("Enter a point x-coordinate: ")
    val inputX = scanner.nextDouble()
    print("Enter a point y-coordinate: ")
    val inputY = scanner.nextDouble()

    val distanceTwoPoints = sqrt((inputY - centerY).pow(2) + (inputX - centerX).pow(2))

    if (distanceTwoPoints > radius) {
        println("The point ($inputX, $inputY) is outside the circle")
    } else if (distanceTwoPoints == radius)
        println("The point ($inputX, $inputY) is on the circle perimeter")
    else {
        println("The point ($inputX, $inputY) is inside  the circle perimeter")
    }
}