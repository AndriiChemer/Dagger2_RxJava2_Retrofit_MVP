package com.example.andrii.rxprojectlesson.app.base;

public interface ViewCommand<V extends BaseContract.View> {
    void executeOn(V view);
}
