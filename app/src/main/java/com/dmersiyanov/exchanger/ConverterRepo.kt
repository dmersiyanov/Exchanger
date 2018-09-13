package com.dmersiyanov.exchanger

import com.dmersiyanov.exchanger.Models.CurrenciesList
import com.dmersiyanov.exchanger.Models.RateResponse
import com.dmersiyanov.exchanger.network.ApiWorker
import com.dmersiyanov.exchanger.network.ConverterService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ConverterRepo {

    private val service: ConverterService by lazy {
        ApiWorker.createConverterService()
    }

    fun getCurrencies(): Single<CurrenciesList> {
        return service.getCurrencies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getRate(request: String): Single<RateResponse> {
        return service.getRate(request, "ultra")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}