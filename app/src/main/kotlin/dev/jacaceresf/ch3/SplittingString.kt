package dev.jacaceresf.ch3

fun main() {

    val value = "12.345-6.A"
    println(value.split("\\.|-".toRegex()))

    //splitting with an arbitrary number of delimiters
    println(value.split(".", "-"))

    val directory = "/Users/jacaceresf/kotlin-book/chapter.adoc"

    parsePath(directory)

    destructuredPathParser(directory)
}

fun parsePath(path: String) {

    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")
}

fun destructuredPathParser(path: String) {

    val regex = """(.+)/(.+)\.(.+)""".toRegex()

    val matchResult = regex.matchEntire(path)

    if (matchResult != null) {
        val (directory, fileName, extension) = matchResult.destructured
        println("Dir: $directory, name: $fileName, ext: $extension")
    }
}