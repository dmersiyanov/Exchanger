package com.dmersiyanov.exchanger

import com.dmersiyanov.exchanger.network.ApiWorker
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.operators.single.SingleObserveOn
import io.reactivex.schedulers.Schedulers

class ConverterRepo {

    fun getCurrencies() {
        ApiWorker.createConverterService().getCurrencies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({


                }, {

                        })
    }

}