package sample.presentation

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

expect object KtorHttpClient {
    val httpClient: HttpClient
}

class SamplePresenter(uiContext: CoroutineContext,
                      baseView: BaseView,
                      val sampleView: SampleView
): CoroutinePresenter(uiContext, baseView) {
    private val client = KtorHttpClient.httpClient

    fun callSimpleApi() {
        try {
            launch {
                val result = client.get<String> {
                    url("https://tools.ietf.org/rfc/rfc1866.txt")
                }
                sampleView.returnString(result)
            }
        } catch (e: Exception){
            sampleView.returnString(e.toString())
        }

    }
}
