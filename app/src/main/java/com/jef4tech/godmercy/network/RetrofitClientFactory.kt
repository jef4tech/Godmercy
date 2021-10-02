package com.jef4tech.godmercy.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClientFactory(var url: String) {

//    fun getRestApis(): RestApis {
//        return getRetroFitClient().create(RestApis::class.java)
//    }
    private fun getRetroFitClient(): Retrofit {

        val builder = OkHttpClient().newBuilder().connectTimeout(3, TimeUnit.MINUTES)
            .readTimeout(3, TimeUnit.MINUTES)

        val client: OkHttpClient = builder
            .addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    val original: Request = chain.request()
                    val httpUrl = original.url
                    val newHttpUrl = httpUrl
                        .newBuilder()
                        .build()

                    val requestBuilder = original
                        .newBuilder()
                        .url(newHttpUrl)
                    val request = requestBuilder
                        .build()
                    return chain.proceed(request)
                }
            }).build()


        return Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}

