package dev.jacaceresf.ch5

fun main() {

    ///using the FILTER function to filter elements from a given collection.
    /// this function just remove the unwanted elements from a collection, doesn't transform them.

    val numbers = listOf(1, 2, 3, 4, 5)
    println(numbers.filter { it % 2 == 0 })

    val createPerson = ::Person
    val people = listOf(createPerson("Jorge", 32), createPerson("Ariel", 23), createPerson("Jannel", 22))
    println(people.filter { it.age > 25 })

    ///if we want to transform a list of elements, we use the MAP function.

    ///squares
    println(numbers.map { it * it })

    ///transform a list a take just the name
//    println(personList.map { it.name })
    println(people.map(Person::name))

    val maxAge = people.maxByOrNull(Person::age)?.age

    val filter = people.filter { it.age == maxAge }
    println(filter)
    val numbersMap = mapOf(0 to "zero", 1 to "one", 2 to "two")
    println(numbersMap.mapValues { it.value.toUpperCase() })


    val canBeInClub27 = { p: Person -> p.age <= 27 }

    ///check if all elements satisfy the given predicate.
    println(people.all(canBeInClub27))

    ///check if some at least one element matches to the predicate.
    println(people.any(canBeInClub27))

    //count how many elements satisfy the predicate
    println(people.count(canBeInClub27))

    //using the groupBy function. It returns a map if the groupBy index and the elements
    println(people.groupBy { it.age })

    val words = listOf("a", "ab", "b")
    println(words.groupBy(String::first))

    val books = listOf(
        Book("Thursday Next", listOf("Jasper Fforde")),
        Book("Mort", listOf("Terry Pratchett")),
        Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman"))
    )

    ///the flatMap functions combines the authors of all the books in a single, flat list
    // Then the toSet function removes duplicates from the list.
    println(books.flatMap { it.authors }.toSet())

}