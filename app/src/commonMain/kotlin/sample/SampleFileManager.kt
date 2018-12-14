package sample

public interface SampleFileManager {
    fun saveFile()
    fun readFile()
}

public expect class PlatformSampleFileManager: SampleFileManager {
    actual override fun readFile()
    actual override fun saveFile()
}
