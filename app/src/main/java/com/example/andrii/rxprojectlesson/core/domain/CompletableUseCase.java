package com.example.andrii.rxprojectlesson.core.domain;

import com.example.andrii.rxprojectlesson.core.scheduler.SchedulerProvider;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;

public abstract class CompletableUseCase<RequestData> {

    private final SchedulerProvider schedulerProvider;

    public CompletableUseCase(SchedulerProvider schedulerProvider) {
        this.schedulerProvider = schedulerProvider;
    }

    public void execute(RequestData requestData, CompletableObserver observer) {
        createCompletable(requestData)
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .subscribe(observer);
    }

    public void executeDelay(RequestData requestData, long delayInMilliseconds, CompletableObserver observer) {
        createCompletable(requestData)
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .delaySubscription(delayInMilliseconds, TimeUnit.MILLISECONDS)
                .subscribe(observer);
    }

    protected abstract Completable createCompletable(RequestData requestData);
}
