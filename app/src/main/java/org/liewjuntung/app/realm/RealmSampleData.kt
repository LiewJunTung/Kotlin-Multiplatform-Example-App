package org.liewjuntung.app.realm

import io.realm.RealmObject
import sample.data.SampleData

data class RealmSampleData(val hello: String): RealmObject()

fun initWithSampleData(sampleData: SampleData): RealmSampleData{
    return RealmSampleData(sampleData.hello)
}

fun initWithRealmSampleData(realmSampleData: RealmSampleData): SampleData {
    return SampleData(realmSampleData.hello)
}
