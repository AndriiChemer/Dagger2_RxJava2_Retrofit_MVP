package com.example.andrii.rxprojectlesson.app.base;

import com.example.andrii.rxprojectlesson.core.rx.DisposableCollector;

import java.util.ArrayDeque;
import java.util.Queue;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<V extends BaseContract.View>
        implements BaseContract.Presenter<V>, DisposableCollector {

    private V view;

    private Queue<ViewCommand<V>> viewCommandQueue = new ArrayDeque<>();
    private CompositeDisposable disposables = new CompositeDisposable();

    @Override
    public final void attachView(V view) {
        if (this.view != null) {
            throw new RuntimeException("Cannot detach View to " + getClass().getSimpleName() + ". View is already attached.");
        }
        this.view = view;
        executeQueuedCommands();
        onViewAttach();
    }

    protected void onViewAttach() {

    }

    @Override
    public void detachView() {
        if (this.view == null) {
            throw new RuntimeException("Cannot detach View to " + getClass().getSimpleName() + ". View is already detached.");
        }
        this.view = null;
        disposables.clear();
    }

    @Override
    public void doOnView(ViewCommand<V> command) {
        if (view != null) {
            executeCommand(command);
        } else {
            queueCommand(command);
        }
    }

    private void executeCommand(ViewCommand<V> command) {
        command.executeOn(view);
    }

    private void queueCommand(ViewCommand<V> command) {
        viewCommandQueue.offer(command);
    }

    private void executeQueuedCommands() {
        ViewCommand<V> viewCommand;
        while ((viewCommand = viewCommandQueue.poll()) != null){
            viewCommand.executeOn(view);
        }
    }

    @Override
    public void collect(Disposable disposable) {
        disposables.add(disposable);
    }
}
