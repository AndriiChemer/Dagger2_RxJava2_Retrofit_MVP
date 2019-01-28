package com.example.andrii.rxprojectlesson.core.domain;

import com.example.andrii.rxprojectlesson.core.scheduler.SchedulerProvider;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.SingleObserver;

public abstract class UseCase<RequestData, ResponseData> {

    private final SchedulerProvider schedulerProvider;

    public UseCase(SchedulerProvider schedulerProvider) {
        this.schedulerProvider = schedulerProvider;
    }

    public void execute(RequestData requestData, SingleObserver<ResponseData> observer) {
        createSingle(requestData)
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .subscribe(observer);
    }

    public void executeDelay(RequestData requestData, long delayInMilliseconds, SingleObserver<ResponseData> observer) {
        createSingle(requestData)
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .delaySubscription(delayInMilliseconds, TimeUnit.MILLISECONDS)
                .subscribe(observer);
    }

    protected abstract Single<ResponseData> createSingle(RequestData requestData);
}
