package dev.jacaceresf.ch6

fun sendEmail(email: String) {
    println("Sending email to $email ...")
}

fun main() {

    /* / the LET function just executes the lambda if the value is not null. */
    var email: String? = "example@mail.com"
    email?.let { sendEmail(it) }

    email = null
    email?.let { sendEmail(it) }

    ///we can use a lateinit modifier which indicates that a value has a lazy initialization

    ///we can call a declared function for a nullable receiver without safe access!

    var input: String? = null
    val nullOrBlank = input.isNullOrBlank()
    println("input is null or blank? $nullOrBlank")
}