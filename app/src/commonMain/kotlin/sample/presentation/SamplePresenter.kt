package sample.presentation

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sample.api.SampleApi
import kotlin.coroutines.CoroutineContext


class SamplePresenter(
    val uiContext: CoroutineContext,
    baseView: BaseView,
    val sampleView: SampleView
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

    override fun onDestroy() {
        super.onDestroy()
    }
}
