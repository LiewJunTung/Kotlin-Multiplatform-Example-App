package sample.presentation

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sample.SampleFileManager
import sample.api.SampleApi
import kotlin.coroutines.CoroutineContext


class SamplePresenter(
    val uiContext: CoroutineContext,
    baseView: BaseView,
    val sampleView: SampleView,
    val fileManager: SampleFileManager
) : CoroutinePresenter(uiContext, baseView) {

    private val api = SampleApi()

    fun callSimpleApi() {
        try {
            GlobalScope.launch(uiContext) {
                val toolString = api.getToolString()
                sampleView.returnString(toolString.hello)
            }
        } catch (e: Exception) {
            sampleView.returnString(e.toString())
        }
    }

    fun readFile(){
        fileManager.readFile()
    }

    fun writeFile(){
        fileManager.saveFile()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
