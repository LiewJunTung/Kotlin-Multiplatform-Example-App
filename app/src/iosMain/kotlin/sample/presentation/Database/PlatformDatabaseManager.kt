package sample.presentation.Database

import sample.data.SampleData

public actual class PlatformDatabaseManager : DatabaseManager {
    actual override fun saveSampleData(sampleData: SampleData) {}
    actual override fun readSampleData(): SampleData {
        TODO()
    }
}
