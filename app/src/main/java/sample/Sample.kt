package sample

actual class Sample {

    var x = 12
    actual fun checkMe(): Int {
        return x
    }

    actual fun saveFile() {

    }

    actual fun readFile() {}

}

actual object Platform {
    actual val name: String
        get() = TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}
