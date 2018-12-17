package sample.presentation.Database

import android.content.Context
import io.realm.Realm
import org.liewjuntung.app.realm.RealmSampleData
import org.liewjuntung.app.realm.initWithSampleData
import sample.data.SampleData

public actual class PlatformDatabaseManager() : DatabaseManager {
    val realm: Realm = Realm.getDefaultInstance()

    actual override fun saveSampleData(sampleData: SampleData) {
        realm.beginTransaction()
        val realmSampleData = initWithSampleData(sampleData)
        realm.copyToRealm(realmSampleData)
        realm.commitTransaction()
    }

    actual override fun readSampleData(): SampleData {
        TODO()
    }
}
