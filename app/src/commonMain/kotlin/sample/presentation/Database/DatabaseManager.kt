package sample.presentation.Database

import sample.SampleFileManager
import sample.data.SampleData

public interface DatabaseManager {
    fun saveSampleData(sampleData: SampleData)
    fun readSampleData(): SampleData?
}

public expect class PlatformDatabaseManager: DatabaseManager {
    actual override fun saveSampleData(sampleData: SampleData)
    actual override fun readSampleData(): SampleData?
}
