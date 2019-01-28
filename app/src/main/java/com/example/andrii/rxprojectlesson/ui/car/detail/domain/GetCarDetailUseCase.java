package com.example.andrii.rxprojectlesson.ui.car.detail.domain;

import com.example.andrii.rxprojectlesson.api.car.CarResponse;
import com.example.andrii.rxprojectlesson.core.domain.UseCase;
import com.example.andrii.rxprojectlesson.core.repository.MainRepository;
import com.example.andrii.rxprojectlesson.core.scheduler.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetCarDetailUseCase extends UseCase<Integer, CarResponse> {

    private final MainRepository repository;

    @Inject
    public GetCarDetailUseCase(SchedulerProvider schedulerProvider, MainRepository repository) {
        super(schedulerProvider);
        this.repository = repository;
    }

    @Override
    protected Single<CarResponse> createSingle(Integer carId) {
        return repository.getCarDetails(carId);
    }
}
