package com.jef4tech.godmercy.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jef4tech.godmercy.model.Prayer
import com.jef4tech.godmercy.model.PrayerSet
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object RestApiImpl {
    val prayers = MutableLiveData<PrayerSet>()


    fun prayersList(): MutableLiveData<PrayerSet> {

        val call = RetrofitClientFactory.restApis.getPrayers()

        call.enqueue(object: Callback<PrayerSet> {
            override fun onFailure(call: Call<PrayerSet>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<PrayerSet>,
                response: Response<PrayerSet>
            ) {
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()
                Log.i("yuppy", "onResponse: "+data)
//
//                val msg = data?.sessions
//                serviceSetterGetter.value = msg?.let { Vaccine(it) }
                prayers.value=data!!
            }
        })

        return prayers
    }
}