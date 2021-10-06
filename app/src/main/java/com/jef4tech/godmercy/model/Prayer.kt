package com.jef4tech.godmercy.model


import com.google.gson.annotations.SerializedName

data class Prayer(
    @SerializedName("img")
    val img: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("prayer")
    val prayer: String
)