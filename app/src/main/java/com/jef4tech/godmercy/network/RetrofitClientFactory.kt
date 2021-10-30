package com.jef4tech.godmercy.network

import androidx.viewbinding.BuildConfig
import com.jef4tech.godmercy.BaseApplication
import com.jef4tech.godmercy.utils.sample.Extensions.hasNetwork
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


object RetrofitClientFactory{
    const val MainServer = "https://jefapi.000webhostapp.com/"

    val retrofitClient: Retrofit.Builder by lazy {
        val cacheSize = 50 * 1024
        val myCache = Cache(File(BaseApplication.ctx?.cacheDir, "responses"), cacheSize.toLong())
        val levelType: Level
        if (BuildConfig.BUILD_TYPE.contentEquals("debug"))
            levelType = Level.BODY else levelType = Level.NONE

        val logging = HttpLoggingInterceptor()
        logging.setLevel(levelType)

        val okhttpClient = OkHttpClient.Builder().cache(myCache)
        okhttpClient.addInterceptor() { chain ->

            var request = chain.request()

            request = if (BaseApplication.ctx?.let { hasNetwork(it) }!!)
                request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
            else
                request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()

            chain.proceed(request)
        }


        Retrofit.Builder()
            .baseUrl(MainServer)
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val restApis: RestApis by lazy {
        retrofitClient
            .build()
            .create(RestApis::class.java)
    }
}

