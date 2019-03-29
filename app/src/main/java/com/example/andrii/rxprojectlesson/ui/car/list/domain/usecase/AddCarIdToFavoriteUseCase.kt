package com.example.andrii.rxprojectlesson.ui.car.list.domain.usecase

import com.example.andrii.rxprojectlesson.core.domain.CompletableUseCase
import com.example.andrii.rxprojectlesson.core.repository.MainRepository
import com.example.andrii.rxprojectlesson.core.scheduler.SchedulerProvider
import io.reactivex.Completable
import javax.inject.Inject

class AddCarIdToFavoriteUseCase @Inject constructor(schedulerProvider: SchedulerProvider,
                                                    private val mainRepository: MainRepository)
    : CompletableUseCase<Int>(schedulerProvider) {

    override fun createCompletable(carId: Int?): Completable =
            mainRepository.addCarId(carId)
}