package com.jef4tech.godmercy.network

import com.jef4tech.godmercy.model.PrayerSet
import retrofit2.Call
import retrofit2.http.GET

interface RestApis {

    @GET("1.json")
    fun getPrayers() : Call<PrayerSet>
}