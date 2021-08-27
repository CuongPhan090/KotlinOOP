package KotlinOOP

/*
Write a program to implement Fraction class with two data members numerator and denominator.
Implement functions to addition, substraction, multiplication, division of two fraction numbers,
inverse of fraction number
 */

class Fraction(var numerator: Double, var denominator: Double) {
    fun addition(fraction: Fraction): Fraction {
        this.numerator = (this.numerator * fraction.denominator) +
                                    (this.denominator * fraction.numerator)
        this.denominator = this.denominator * fraction.denominator
        return this
    }

    fun substraction(fraction: Fraction): Fraction {
        this.numerator = (this.numerator * fraction.denominator) -
                (this.denominator * fraction.numerator)
        this.denominator = (this.denominator * fraction.denominator)
        return this
    }

    fun multiplication(fraction: Fraction): Fraction {
        this.numerator = (this.numerator * fraction.numerator)
        this.denominator = (this.denominator * fraction.denominator)
        return this
    }

    fun division(fraction: Fraction): Fraction {
        this.numerator = (this.numerator * fraction.denominator)
        this.denominator = (this.denominator * fraction.numerator)
        return this
    }

    fun inverse(): Fraction {
        this.numerator = this.denominator
        this.denominator = this.numerator
        return this
    }
}

fun main() {
    val fraction1 = Fraction(1.0, 2.0)
    val fraction2 = Fraction(1.0, 2.0)
    val addFraction = fraction1.addition(fraction2)
    println("The denominator of adding 2 fractions: ${addFraction.denominator}")
    println("The numerator of adding 2 fractions: ${addFraction.numerator}")

    val subtractFraction = fraction1.substraction(fraction2)
    println("The numerator of subtracting 2 fractions: ${subtractFraction.numerator}")
    println("The denominator of subtracting 2 fractions: ${subtractFraction.denominator}")

    val multiplyFraction = fraction1.multiplication(fraction2)
    println("The numerator of multiplying 2 fractions: ${multiplyFraction.numerator}")
    println("The denominator of multiplying 2 fractions: ${multiplyFraction.denominator}")

    val divideFraction = fraction1.division(fraction2)
    println("The numerator of dividing 2 fractions: ${divideFraction.numerator}")
    println("The denominator of dividing 2 fractions: ${divideFraction.denominator}")

    val inverseFraction = fraction1.inverse()
    println("The numerator of the inverse fraction: ${inverseFraction.numerator}")
    println("The denominator of the inverse fraction: ${inverseFraction.denominator}")
}