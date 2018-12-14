package sample

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.Foundation.*
import kotlin.coroutines.CoroutineContext

actual class Sample {
    actual fun checkMe() = 7

    actual fun saveFile() {
        val paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, true)
        val documentDirectory:NSString = paths[0] as NSString

        val filePath = documentDirectory.stringByAppendingPathComponent("file.txt")

        val str: NSString = ("Hello World JT Hey yo " as Any) as NSString
        str.writeToFile(filePath, atomically = true, encoding = NSUTF8StringEncoding, error = null)
    }

    actual fun readFile() {
        val paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, true)
        val documentDirectory:NSString = paths[0] as NSString
        val filePath = documentDirectory.stringByAppendingPathComponent("file.txt")
        val str = NSString.stringWithContentsOfFile(path=filePath, encoding=NSUTF8StringEncoding, error = null)
        print(str)
    }
}

actual object Platform {
    actual val name: String = "iOS"
}

object MainLoopDispatcher: CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        NSRunLoop.mainRunLoop().performBlock {
            block.run()
        }
    }
}
