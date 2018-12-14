package sample

import platform.Foundation.*

public actual class PlatformSampleFileManager: SampleFileManager {
    actual override fun readFile() {
        val paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, true)
        val documentDirectory:NSString = paths[0] as NSString
        val filePath = documentDirectory.stringByAppendingPathComponent("file.txt")
        val str = NSString.stringWithContentsOfFile(path=filePath, encoding=NSUTF8StringEncoding, error = null)
        print(str)
    }

    actual override fun saveFile() {
        val paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, true)
        val documentDirectory: NSString = paths[0] as NSString

        val filePath = documentDirectory.stringByAppendingPathComponent("file.txt")

        val str: NSString = ("Hello World JT Hey yo " as Any) as NSString
        str.writeToFile(filePath, atomically = true, encoding = NSUTF8StringEncoding, error = null)
    }


}
