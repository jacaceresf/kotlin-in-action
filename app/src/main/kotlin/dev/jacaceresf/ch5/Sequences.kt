package dev.jacaceresf.ch5

fun main() {
    val createPerson = ::Person
    val people = listOf(
        createPerson("Jorge", 32),
        createPerson("Ariel", 23),
        createPerson("Jannel", 22)
    )

    /// converts the initial collection to sequence and avoid creates a collection for the map and filter function calling.
    /// this is more efficient when we are using a collection of several items.
    val result = people.asSequence() /// => Sequence is the interface for lazy collections operations.
        .map(Person::name)
        .filter { it.startsWith("A") }
        .toList()
    println(result)

    val numbers = listOf(1, 2, 3, 4)
    ///in Sequences all operations are applied to each element sequentially.
    numbers.asSequence()
        .map { print("map -> $it "); it * it }
        .filter { print("filter -> $it \n"); it % 2 == 0 }
        .toList() // if we don't call this terminal function, all the computations functions are postponed

    println(numbers.asSequence().map { it * it }.find { it > 3 })


    ///If map goes first, each element is transformed. If you apply filter first, inappropriate elements are filtered out as soon as possible and aren’t transformed.
    val usingMapFirst = people.asSequence().map(Person::name).filter { it.length <= 5 }.toList()

    val usingFilterFirst = people.asSequence().filter { it.name.length <= 5 }.map { it.name }.toList()

    println(usingMapFirst)
    println(usingFilterFirst)
}