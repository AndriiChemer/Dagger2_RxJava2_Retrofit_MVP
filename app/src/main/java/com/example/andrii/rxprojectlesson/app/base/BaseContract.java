package com.example.andrii.rxprojectlesson.app.base;

public interface BaseContract {

    interface View {

    }

    interface Presenter<V extends View> {

        void attachView(V view);

        void detachView();

        void doOnView(ViewCommand<V> command);
    }
}
