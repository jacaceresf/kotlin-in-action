package dev.jacaceresf.ch4

interface Clickable {

    fun click()

    ///a default method
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun showOff() = println("I'm focusable!")
}


/// kotlin uses the colon in place of the implement keyword.
class Button : Clickable, Focusable {

    ///the override modifier is mandatory!
    override fun click() {
        TODO("Not yet implemented")
    }

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

}

fun main() {

    val button = Button()

    button.showOff()

}