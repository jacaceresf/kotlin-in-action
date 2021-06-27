package dev.jacaceresf.ch3

import java.lang.IllegalArgumentException

class User(val id: Int, val name: String, val address: String)

/// extension function for user
fun User.validateBeforeSave() {

    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id: empty $fieldName")
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser(user: User) {
    user.validateBeforeSave()
}

fun main() {

    val usr = User(1, "", "")

    saveUser(usr)
}