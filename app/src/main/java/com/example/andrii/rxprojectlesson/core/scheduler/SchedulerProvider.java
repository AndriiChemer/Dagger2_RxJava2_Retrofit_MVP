package com.example.andrii.rxprojectlesson.core.scheduler;

import io.reactivex.Scheduler;

public interface SchedulerProvider {

    Scheduler io();

    Scheduler ui();
}
