package com.example.andrii.rxprojectlesson.app.base;

import android.content.Context;

public class ClickableFragment<V extends BaseContract.View, P extends BaseContract.Presenter<V>, L>
        extends BaseFragment<V, P> {

    protected L listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        setupListener(context);
    }

    public void setupListener(Context context) {
        try {
            this.listener = (L) context;
        } catch (ClassCastException ex) {
            String message = context.getClass().getSimpleName() + " must implement " +
                    getClass().getSimpleName() + " callback interface";
            throw new IllegalStateException(message);
        }
    }
}
