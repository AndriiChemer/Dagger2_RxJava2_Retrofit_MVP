package com.example.andrii.rxprojectlesson.ui.main;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.app.base.BaseActivity;
import com.example.andrii.rxprojectlesson.app.base.BaseContract;
import com.example.andrii.rxprojectlesson.ui.registration.RegistrationActivity;

import butterknife.OnClick;

public class MainActivity
        extends BaseActivity<MainContract.View, MainContract.Presenter>
        implements MainContract.View {

    @OnClick(R.id.registration_rx_validation)
    public void registrationRxValidationClick(){
        presenter.onRegistrationRxValidationButtonClick();
    }

    @Override
    protected int getLayoutResourceID() {
        return R.layout.activity_main;
    }

    @Override
    public void openRegistrationScreen() {
        RegistrationActivity.start(this);
    }
}
