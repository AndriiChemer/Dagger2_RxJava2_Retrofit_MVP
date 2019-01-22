package com.example.andrii.rxprojectlesson.core.rx;

import io.reactivex.disposables.Disposable;

public interface DisposableCollector {

    void collect(Disposable disposable);
}
