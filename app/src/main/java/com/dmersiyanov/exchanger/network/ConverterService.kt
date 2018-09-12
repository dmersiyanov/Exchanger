package com.dmersiyanov.exchanger.network

import com.dmersiyanov.exchanger.Models.CurrenciesList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*


interface ConverterService {
//
//    @GET(".")
//    fun getRate(@Query("apikey") key: String, @Query("t") title: String): Observable<>

    @GET("currencies")
    fun getCurrencies(): Single<CurrenciesList>

}