package KotlinOOP

import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt
// find distance of 2 points in 2d plane and 3d plane
class Point(val x1: Float, val y2: Float) {

}


open class Plane1D (val x1: Float, val x2: Float) {
    open fun calculateDistance(): Float {
        return abs(x2-x1)
    }

}
class Plane2D(
    x1: Float, val y1: Float,
    x2: Float, val y2: Float): Plane1D(x1, x2) {

    override fun calculateDistance(): Float {
        return sqrt((x2-x1).pow(2) + (y2-y1).pow(2))
    }
}

class Plane3D (
    x1: Float, val y1: Float, val z1: Float,
    x2: Float, val y2: Float, val z2: Float) : Plane1D(x1, x2) {

    override fun calculateDistance(): Float {
        return sqrt((x2-x1).pow(2) + (y2-y1).pow(2) + (z2-z1).pow(2))
    }
}


fun main() {
    val plane2dPoint = Plane2D(1f,1f,2f,2f)
    println("Distance between 2 points in 2d plane ${plane2dPoint.calculateDistance()}")
    val plane3dPoint = Plane3D(1f,1f,2f,2f, 3f, 3f)
    println("Distance between 2 points in 3d plane   ${plane3dPoint.calculateDistance()}")
}