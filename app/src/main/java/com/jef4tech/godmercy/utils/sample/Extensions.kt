package com.jef4tech.godmercy.utils.sample

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.ImageView
import androidx.annotation.RequiresPermission
import com.bumptech.glide.Glide

object Extensions {
    fun hasNetwork(context: Context): Boolean? {
        var isConnected: Boolean? = false // Initial Value
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }
    fun loadImagefromUrl(context: Context,imgView:ImageView,url:String){
        Glide.with(context).load(url).fitCenter().into(imgView)
    }

}