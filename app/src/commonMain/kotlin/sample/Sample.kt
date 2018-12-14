package sample

expect class Sample() {
    fun checkMe(): Int
    fun saveFile()
    fun readFile()
}

expect object Platform {
    val name: String
}


fun hello(): String = "Hello from ${Platform.name}"

class Proxy {
    fun proxyHello() = hello()
}

fun main(args: Array<String>) {
    println(hello())
}
