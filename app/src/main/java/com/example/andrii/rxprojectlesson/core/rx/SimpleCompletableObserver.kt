package com.example.andrii.rxprojectlesson.core.rx

import io.reactivex.CompletableObserver
import io.reactivex.disposables.Disposable

abstract class SimpleCompletableObserver(val disposableCollector: DisposableCollector) : CompletableObserver {

    override fun onSubscribe(disposable: Disposable) {
        disposableCollector.collect(disposable)

        onSubscribe()
    }

    fun onSubscribe() {

    }
}