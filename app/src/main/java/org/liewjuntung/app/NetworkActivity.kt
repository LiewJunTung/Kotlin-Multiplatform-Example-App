package org.liewjuntung.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import sample.presentation.BaseView
import sample.presentation.SampleView

class NetworkActivity : AppCompatActivity(), BaseView, SampleView {
    override fun showError(error: Throwable) {

    }

    override fun returnString(result: String) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)
    }
}
