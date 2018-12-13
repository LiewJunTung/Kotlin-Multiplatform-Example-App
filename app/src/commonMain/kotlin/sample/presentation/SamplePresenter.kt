package sample.presentation

import io.ktor.client.HttpClient
import io.ktor.client.request.*
import io.ktor.http.takeFrom
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class SamplePresenter(
    val uiContext: CoroutineContext,
    baseView: BaseView,
    val sampleView: SampleView
) : CoroutinePresenter(uiContext, baseView) {
    private val client = HttpClient()

    fun callSimpleApi() {
        try {
            GlobalScope.launch(uiContext) {
                getToolString()
            }
        } catch (e: Exception) {
            sampleView.returnString(e.toString())
        }
    }

    suspend fun getToolString() = client.get<String> {
        url("https://tools.ietf.org/rfc/rfc1866.txt")
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun HttpRequestBuilder.apiUrl() {
        url {
            takeFrom("https://tools.ietf.org/rfc/rfc1866.txt")
            //encodedPath = path
        }
    }
}
