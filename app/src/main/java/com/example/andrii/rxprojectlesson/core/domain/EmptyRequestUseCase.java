package com.example.andrii.rxprojectlesson.core.domain;

import com.example.andrii.rxprojectlesson.core.scheduler.SchedulerProvider;

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

    protected abstract Single<ResponseData> createSingle();
}
