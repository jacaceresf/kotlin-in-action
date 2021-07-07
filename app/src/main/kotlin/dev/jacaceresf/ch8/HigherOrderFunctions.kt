package dev.jacaceresf.ch8

import java.lang.StringBuilder

fun main() {

    ///declaring a FUNCTION TYPE: types in parentheses, followed by an arrow and the return type of the function.
    val sum: (Int, Int) -> Int = { x, y -> x + y }

    // a Unit type is used to specify if a function returns no meaningful value.
    // with a function type is mandatory to specify the Unit if the doesn't return anything.
    val action: () -> Unit = { println(42) }

    println(sum(2, 3))

    ///declaring a function type that returns a nullable
//    var canReturnNull: (Int, Int) -> Int? = { null }

    ///declaring a nullable variable of a function type
    var funOrNull: ((Int, Int) -> Int)? = null


    /// calling functions passed as arguments
    twoAndThree { a, b -> a - b }
    twoAndThree { a, b -> a / b }

    println("ab23c".filter { it in 'a'..'z' })

    val letters = listOf("Alpha", "Bravo", "Charlie", "Delta")
    println(letters.joinToString())

    println(letters.joinToString { it.toLowerCase() })

    println(letters.joinToString(separator = "///", prefix = "+++", postfix = "???") { it.toUpperCase() })

}

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is -> $result")
}

fun String.filter(predicate: (Char) -> Boolean): String {

    val sb = StringBuilder()

    for (idx in 0 until length) {
        val element = get(idx)
        println("Getting elements[$idx] => $element")
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}

///specifying a default value for a parameter of a function type.
fun <T> Collection<T>.joinToString(
    separator: String = "|^|",
    prefix: String = "",
    postfix: String = "",
    transform: (T) -> String = { it.toString() } ///we can receive a function type as parameter to transform the result
): String {

    val result = StringBuilder(prefix)

    for ((idx, element) in this.withIndex()) {
        if (idx > 0) result.append(separator)
        result.append(transform(element))
    }

    result.append(postfix)
    return result.toString()
}