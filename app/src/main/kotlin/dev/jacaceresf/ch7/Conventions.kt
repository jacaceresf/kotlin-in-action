package dev.jacaceresf.ch7

import java.lang.IndexOutOfBoundsException
import java.math.BigDecimal
import java.math.BigInteger

data class Point(val x: Int, val y: Int) {

    //Overloading arithmetic operations
    //we must use the OPERATOR modifier
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    operator fun Point.times(scale: BigInteger): Point {
        return Point(x * scale.toInt(), y * scale.toInt())
    }

    operator fun Point.get(index: Int): Int {
        return when (index) {
            0 -> x
            1 -> y
            else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
        }
    }
}

fun main() {

    val point1 = Point(10, 30)

    val point2 = Point(34, 43)

    println(point1 + point2)

    //immutable list
    val list = arrayListOf(1, 2)
    list += 3

    val newList = list + listOf(5, 4)
    println(list)
    println(newList)


}
