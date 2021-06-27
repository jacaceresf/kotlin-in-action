package dev.jacaceresf.ch5



fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach {
        println("$prefix => $it")
    }
}

/**
 * Changing local variables with a lambda.
 *
 * Unlike in Java, in Kotlin we can use non-final variables and even modify them in a lambda.
 */
fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0

    responses.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }

    println("Got [$clientErrors] client errors. Got [$serverErrors] server errors.")
}

fun main() {
//    val people = listOf(Person(name = "Jorge", age = 23), Person(name = "Diego", age = 20))
//
//    ///searching using lambda
//    println(people.maxByOrNull { it.age })
//
//    ///searching using method reference
//    println(people.maxByOrNull(Person::age))
//
//    val sum = { x: Int, y: Int -> x + y }
//
//    println(sum(23, 34))

    val errors = listOf(
        "403 Forbidden",
        "404 Not Found",
        "500 Internal Server Error",
        "418 I'm a teapot",
        "204 No content",
        "200 Ok"
    )
    printMessageWithPrefix(errors, "Error:")
    printProblemCounts(errors)

    //storing the action of creating a class instance using a constructor reference.

    val createPerson = ::Person

    val p1 = createPerson("Jorge", 21)
    val p2 = createPerson("Ariel", 32)
    println(p1)
    println(p2)
}