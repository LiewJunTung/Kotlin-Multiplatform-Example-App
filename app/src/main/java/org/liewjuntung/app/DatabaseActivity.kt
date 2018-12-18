package org.liewjuntung.app

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_database.*
import sample.data.SampleData
import sample.presentation.Database.PlatformDatabaseManager
import sample.presentation.SharedPref.DatabasePresenter
import sample.presentation.SharedPref.DatabaseView
import io.realm.RealmConfiguration



class DatabaseActivity: AppCompatActivity(), DatabaseView {
    val presenter by lazy { DatabasePresenter(this, PlatformDatabaseManager()) }


    override fun getSampleData(sampleData: SampleData) {
        valueText.text = sampleData.hello
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Realm.init(this)
        val config = RealmConfiguration.Builder().name("myrealm.realm").build()
        Realm.setDefaultConfiguration(config)
        setContentView(R.layout.activity_database)
        val tv = TextView(this)

        saveButton.setOnClickListener {
            presenter.saveString(valueTextField.text.toString())
        }

    }
}
