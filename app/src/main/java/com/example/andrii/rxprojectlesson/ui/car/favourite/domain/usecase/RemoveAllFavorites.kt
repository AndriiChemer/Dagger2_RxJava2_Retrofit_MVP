package com.example.andrii.rxprojectlesson.ui.car.favourite.domain.usecase

import com.example.andrii.rxprojectlesson.core.domain.EmptyRequestUseCase
import com.example.andrii.rxprojectlesson.core.repository.MainRepository
import com.example.andrii.rxprojectlesson.core.scheduler.SchedulerProvider
import io.reactivex.Single
import javax.inject.Inject

class RemoveAllFavorites @Inject constructor(schedulerProvider: SchedulerProvider,
                                             val mainRepository: MainRepository) :
        EmptyRequestUseCase<Boolean>(schedulerProvider) {

    override fun createSingle(): Single<Boolean> =
            mainRepository.clearFavorite()
}