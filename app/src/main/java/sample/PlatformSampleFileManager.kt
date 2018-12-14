package sample

import android.content.Context
import android.util.Log
import java.io.File

public actual class PlatformSampleFileManager(val context: Context) : SampleFileManager {
    actual override fun readFile() {
        Log.d("READ FILE", File(context.filesDir, "hello.txt").readText())
    }

    actual override fun saveFile() {
        val fileContent = "Hello World! Android"
        File(context.filesDir, "hello.txt").appendText(fileContent)


    }


}
