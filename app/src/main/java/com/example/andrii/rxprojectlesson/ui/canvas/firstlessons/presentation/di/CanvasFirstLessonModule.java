package com.example.andrii.rxprojectlesson.ui.canvas.firstlessons.presentation.di;

import com.example.andrii.rxprojectlesson.ui.canvas.firstlessons.presentation.CanvasFirstLessonsContract;
import com.example.andrii.rxprojectlesson.ui.canvas.firstlessons.presentation.CanvasFirstLessonsPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class CanvasFirstLessonModule {

    @Binds
    abstract CanvasFirstLessonsContract.Presenter bindPresenter(CanvasFirstLessonsPresenter presenter);
}
