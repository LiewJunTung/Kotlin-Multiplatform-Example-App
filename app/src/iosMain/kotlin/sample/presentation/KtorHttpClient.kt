package sample.presentation

import io.ktor.client.HttpClient
import io.ktor.client.engine.ios.Ios

actual object KtorHttpClient {
    actual val httpClient: HttpClient
        get() = HttpClient(Ios)
}
