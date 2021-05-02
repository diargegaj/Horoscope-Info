package com.diargegaj.horoscopeinfo.instances

import com.diargegaj.horoscopeinfo.service.HoroscopeService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Diar Gegaj on 21-05-02.
 */
object RetrofitInstance {
    private val retrofit by lazy {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val original = chain.request()

            val request = original.newBuilder()
                .header("X-RapidAPI-Key", "fcfd0e9f8bmshd27427e3da163a0p12c997jsn6a9ffcbb45f1")
                .header("X-RapidAPI-Host", "sameer-kumar-aztro-v1.p.rapidapi.com")
                .method(original.method(), original.body())
                .build()

            chain.proceed(request)
        }

        val client = httpClient.build()

        Retrofit.Builder()
            .baseUrl(HoroscopeService.API_LINK)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }

    val service = retrofit.create(HoroscopeService::class.java)
}