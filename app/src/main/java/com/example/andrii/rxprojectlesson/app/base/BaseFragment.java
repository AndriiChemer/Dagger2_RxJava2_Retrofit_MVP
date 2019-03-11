package com.example.andrii.rxprojectlesson.app.base;

public class BaseFragment<V extends BaseContract.View, P extends BaseContract.Presenter<V>>
        extends MVPFragment<V, P> {
}
