package sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import sample.presentation.BaseView
import sample.presentation.SamplePresenter
import sample.presentation.SampleView

actual class Sample {
    actual fun checkMe() = 44
}

actual object Platform {
    actual val name: String = "Android"
}

class MainActivity : AppCompatActivity(), SampleView, BaseView {
    override fun returnString(result: String) {
        runOnUiThread {
            text_string.text = result
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        }
    }

    override fun showError(error: Throwable) {
        Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
    }

    private val presenter by lazy { SamplePresenter(Dispatchers.Main, this, this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hello()
        Sample().checkMe()
        presenter.callSimpleApi()
        setContentView(R.layout.activity_main)
    }
}
