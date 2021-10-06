package com.jef4tech.godmercy.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jef4tech.godmercy.model.Prayer
import com.jef4tech.godmercy.model.PrayerSet
import com.jef4tech.godmercy.network.RestApiImpl

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    var prayerList = MutableLiveData<PrayerSet>()
    fun getPrayers():LiveData<PrayerSet>{
        prayerList = RestApiImpl.prayersList()
        return prayerList
    }
}