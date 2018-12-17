package org.liewjuntung.app

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import sample.data.SampleData
import sample.presentation.SharedPref.DatabaseView

class DatabaseActivity: AppCompatActivity(), DatabaseView {
    override fun getSampleData(sampleData: SampleData) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)


    }
}
