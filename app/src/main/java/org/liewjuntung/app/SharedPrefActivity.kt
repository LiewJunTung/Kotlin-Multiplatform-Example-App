package org.liewjuntung.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_shared_pref.*
import sample.presentation.SharedPref.SharedPrefPresenter
import sample.presentation.SharedPref.SharedPrefView

class SharedPrefActivity : AppCompatActivity(), SharedPrefView {

    val presenter = SharedPrefPresenter(this)

    override fun getSavedString(savedString: String) {
        valueText.text = savedString
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)

        saveButton.setOnClickListener {
            val str = valueTextField.text.toString()
            presenter.saveString(str)
            presenter.retrieveSaveString()
        }
        presenter.retrieveSaveString()
    }
}
