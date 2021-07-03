package dev.jacaceresf.ch5

import java.lang.StringBuilder
import javax.naming.Context

fun alphabet(): String {
    val stringBuilder = StringBuilder()

    //we can use the name of the method without the THIS keyword!
    return with(stringBuilder) {
        for (letter in 'A'..'Z') {
            append(" ")
            append(letter)
        }
        append("\nNow I know the alphabet!")
        toString()
    }
}

/// Expression body syntax
fun refactoredAlphabet() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(" ")
        append(letter)
    }
    append("\nNow I refactored the alphabet method!")
    toString()
}

/// The APPLY extension function is useful when you're
/// creating an instance of an object and need to initialize some properties
/// In Java this is accomplished by using a Builder object.
fun alphabetWithApply() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    toString()
}

fun main() {
    val alphabet = alphabet()
    println(alphabet)

    println(refactoredAlphabet())

    println(alphabetWithApply())
}
