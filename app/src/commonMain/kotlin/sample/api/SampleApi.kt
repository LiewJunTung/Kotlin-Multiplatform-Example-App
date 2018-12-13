package sample.api

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.url
import sample.data.SampleData

class SampleApi {
    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer().apply {
                setMapper(SampleData::class, SampleData.serializer())
            }
        }
    }

    suspend fun getToolString(): SampleData = client.get {
        url("https://api.myjson.com/bins/o1rh8")
    }
}
