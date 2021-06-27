package dev.jacaceresf.ch3

import java.lang.StringBuilder

class Collections {


}

fun main() {

    val list = arrayListOf(1, 7, 53)
    println(list)

    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    print(map.javaClass)


    ///getting the last element
    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())

    val numbers = setOf(1, 5, 6, 3, 3, 99, 203, 2, 1)
    println(numbers.maxOrNull())

    println(joinToString(strings, " -|- ", "[", "]"))
    println(joinToString(strings, " -|- ", "[", "]"))

    println(
        strings.joinToStringExt(separator = "|", postfix = ")", prefix = "(")
    )

    println(strings.join(separator = "|+|"))
    println("Kotlin".lastChar())
}



