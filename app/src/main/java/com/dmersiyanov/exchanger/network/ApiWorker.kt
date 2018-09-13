package com.dmersiyanov.exchanger.network

import com.dmersiyanov.exchanger.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiWorker {

    private const val server: String = "https://free.currencyconverterapi.com/api/v6/"

    fun createConverterService(): ConverterService
            = getRetrofit().create(ConverterService::class.java)


    fun getRetrofit() : Retrofit {
        val httpBuilder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG){
            with(HttpLoggingInterceptor()){
                level = HttpLoggingInterceptor.Level.BODY
                httpBuilder.addInterceptor(this)
            }
        }

        return Retrofit.Builder()
                .baseUrl(server)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpBuilder.build())
                .build()
    }

    private val gson: Gson by lazy {
        GsonBuilder().create()
    }

}