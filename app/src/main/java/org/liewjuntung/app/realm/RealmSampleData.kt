package org.liewjuntung.app.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import sample.data.SampleData

open class RealmSampleData(@PrimaryKey var id: Int = 0, var hello: String? = null): RealmObject()

fun initWithSampleData(sampleData: SampleData): RealmSampleData{
    return RealmSampleData(1, sampleData.hello)
}

fun initWithRealmSampleData(realmSampleData: RealmSampleData): SampleData {
    return SampleData(realmSampleData.hello ?: "")
}
