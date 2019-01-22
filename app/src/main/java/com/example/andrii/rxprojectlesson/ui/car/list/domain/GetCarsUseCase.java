package com.example.andrii.rxprojectlesson.ui.car.list.domain;

import com.example.andrii.rxprojectlesson.api.car.CarResponse;
import com.example.andrii.rxprojectlesson.core.domain.EmptyRequestUseCase;
import com.example.andrii.rxprojectlesson.core.repository.MainRepository;
import com.example.andrii.rxprojectlesson.core.scheduler.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetCarsUseCase extends EmptyRequestUseCase<List<CarResponse>> {

    private final MainRepository repository;

    @Inject
    public GetCarsUseCase(SchedulerProvider schedulerProvider, MainRepository repository) {
        super(schedulerProvider);
        this.repository = repository;
    }

    @Override
    protected Single<List<CarResponse>> createSingle() {
        return repository.getCars();
    }
}
