package sample.presentation

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android

actual object KtorHttpClient {
    actual val httpClient: HttpClient
        get() = HttpClient(Android)
}
