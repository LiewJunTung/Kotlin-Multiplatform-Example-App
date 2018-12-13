package org.liewjuntung.app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import kotlinx.coroutines.Dispatchers

import sample.presentation.BaseView
import sample.presentation.SampleView
import sample.presentation.SamplePresenter


class MainActivity : AppCompatActivity(), BaseView, SampleView {
    val presenter by lazy { SamplePresenter(Dispatchers.Main,this, this) }

    override fun showError(error: Throwable) {

    }

    override fun returnString(result: String) {
        Log.d("RETURN", result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.callSimpleApi()
//        button_network.setOnClickListener {
//            startExampleActivity(NetworkActivity::class.java)
//        }

    }

    fun startExampleActivity(activityClass: Class<*>){
        startActivity(Intent(this, activityClass))
    }

}
