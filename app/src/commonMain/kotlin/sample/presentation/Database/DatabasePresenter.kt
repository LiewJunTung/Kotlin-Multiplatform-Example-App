package sample.presentation.SharedPref

import sample.data.SampleData
import sample.presentation.Database.DatabaseManager

class DatabasePresenter(val sharedPrefView: DatabaseView, val databaseManager: DatabaseManager) {
    fun saveString(text: String) {
        databaseManager.saveSampleData(sampleData = SampleData(text))
    }

    fun retrieveSaveString(){
        val sampleData = databaseManager.readSampleData() ?: SampleData(hello = "")
        sharedPrefView.getSampleData(sampleData)
    }
}
