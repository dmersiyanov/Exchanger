package com.dmersiyanov.exchanger.network

import com.dmersiyanov.exchanger.Models.CurrenciesList
import com.dmersiyanov.exchanger.Models.RateResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface ConverterService {

//    https://api.currencyconverterapi.com/api/v6/convert?q=USD_PHP,PHP_USD&compact=ultra
//
    @GET("convert")
    fun getRate(@Query("q") key: String, @Query("compact") mode: String): Single<RateResponse>

    @GET("currencies")
    fun getCurrencies(): Single<CurrenciesList>

}