package com.jef4tech.godmercy.model


import com.google.gson.annotations.SerializedName

data class PrayerSet(
    @SerializedName("prayers")
    val prayers: List<Prayer>
)