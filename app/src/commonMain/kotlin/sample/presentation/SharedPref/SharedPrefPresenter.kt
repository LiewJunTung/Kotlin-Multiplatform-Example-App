package sample.presentation.SharedPref

import com.netguru.multiplatformstorage.MultiPlatformStorage

class SharedPrefPresenter(val sharedPrefView: SharedPrefView) {

    val storage = MultiPlatformStorage("storage")


    fun saveString(text: String) {
        storage.putString("animal", text)
    }

    fun retrieveSaveString(){
        val savedString = storage.getString("animal", "")
        sharedPrefView.getSavedString(savedString ?: "")
    }
}
