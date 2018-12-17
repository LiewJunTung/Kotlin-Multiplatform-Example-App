package sample.presentation.SharedPref

import sample.data.SampleData

interface DatabaseView {
    fun getSampleData(sampleData: SampleData)
}
