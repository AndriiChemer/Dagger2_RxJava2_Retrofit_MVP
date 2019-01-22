package com.example.andrii.rxprojectlesson.core.rx;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class SimpleSingleObserver<T> implements SingleObserver<T> {

    private final DisposableCollector disposableCollector;

    @Override
    public void onSubscribe(Disposable disposable) {
        disposableCollector.collect(disposable);

        onSubscribe();
    }

    public void onSubscribe() {

    }
}
