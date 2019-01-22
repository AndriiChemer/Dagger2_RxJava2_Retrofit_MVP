package com.example.andrii.rxprojectlesson.core.domain;

import com.example.andrii.rxprojectlesson.core.scheduler.SchedulerProvider;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.SingleObserver;

public abstract class EmptyRequestUseCase<ResponseData> {

    private final SchedulerProvider schedulerProvider;

    public EmptyRequestUseCase(SchedulerProvider schedulerProvider) {
        this.schedulerProvider = schedulerProvider;
    }

    public void execute(SingleObserver<ResponseData> observer) {
        createSingle()
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .subscribe(observer);
    }

    public void executeDelay(long delayInMilliseconds, SingleObserver<ResponseData> observer) {
        createSingle()
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .delaySubscription(delayInMilliseconds, TimeUnit.MILLISECONDS)
                .subscribe(observer);
    }

    protected abstract Single<ResponseData> createSingle();
}
