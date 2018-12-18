package sample.presentation.Database

import android.content.Context
import io.realm.Realm
import org.liewjuntung.app.realm.RealmSampleData
import org.liewjuntung.app.realm.initWithRealmSampleData
import org.liewjuntung.app.realm.initWithSampleData
import sample.data.SampleData

public actual class PlatformDatabaseManager() : DatabaseManager {
    val realm: Realm = Realm.getDefaultInstance()

    actual override fun saveSampleData(sampleData: SampleData) {
        realm.beginTransaction()
        val rsd = realm.createObject(RealmSampleData::class.java)
        rsd.id = 1
        rsd.hello = sampleData.hello
        realm.copyToRealmOrUpdate(rsd)
        realm.commitTransaction()
    }

    actual override fun readSampleData(): SampleData? {
        val realmSampleData = realm.where(RealmSampleData::class.java).findFirst() ?: return null
        return initWithRealmSampleData(realmSampleData)
    }
}
