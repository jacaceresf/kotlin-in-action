package dev.jacaceresf.ch3

import java.lang.StringBuilder

const val UNIX_LINE_SEPARATOR = "\n"

/// declare as a normal function
fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ",",
    prefix: String = "[",
    postfix: String = "]"
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)

    return result.toString()
}

fun String.lastChar(): Char = this[this.length - 1]

///declared as an extension function
fun <T> Collection<T>.joinToStringExt(
    separator: String = ",",
    prefix: String = "[",
    postfix: String = "]"
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)

    return result.toString()
}

///declaring an extension function just for a collection of Strings
fun Collection<String>.join(
    separator: String = ",",
    prefix: String = "[",
    postfix: String = "]"
) = joinToStringExt(separator, prefix, postfix)
