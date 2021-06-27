package dev.jacaceresf.ch4

/**
 * an open class that can be inherited
 */
open class RichButton : Clickable {

    /**
     * a final function by default that can't be override
     */
    fun disable() {}

    /***
     * you may override it in a subclass
     */
    open fun animate() {}

    /**
     * it overrides an open function and is open as well
     *
     * if we want this to be a final function, we must declare it explicitly
     */
    override fun click() {
        TODO("Not yet implemented")
    }

}


abstract class Animated {

    abstract fun animate() //it must be overridden in subclass

    /// non-abstract functions aren't open by default
    open fun stopAnimating() {}
    fun animateTwice() {}

}
