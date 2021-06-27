package dev.jacaceresf.ch2

import java.io.BufferedReader
import java.util.*

class KotlinBasics {


}

fun readNumber(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        println(e)
        return
    }
    println(number)
}

fun main() {

    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'G') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    println(binaryReps)
}