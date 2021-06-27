package dev.jacaceresf.ch4

import java.util.*

class A {
    companion object {
        fun bar() {
            println("Companion object called!")
        }

        fun sum(n1: Int, n2: Int): Int {
            println("Let's return the sum between $n1 and $n2")
            return n1 + n2
        }
    }
}

class User private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) =
            User(email.substringBefore('@'))


        fun newFacebookUser(accountId: Int) =
            User(accountId.toString())

    }
}

fun main() {
    A.bar()
    val sum = A.sum(n1 = 20, n2 = 35)
    println("Sum result => $sum")

    ///calling a private constructor from a companion object to recreate the factory pattern
    val subscribingUser = User.newSubscribingUser("jorge97caceres@gmail.com")
    val facebookUser = User.newFacebookUser(Random().nextInt())

    println(subscribingUser.nickname)
}

