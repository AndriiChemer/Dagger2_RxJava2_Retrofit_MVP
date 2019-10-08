package com.example.andrii.rxprojectlesson.ui.car.account.registration.presentation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.app.base.ClickableFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class RegistrationFragment
        extends ClickableFragment<RegistrationContract.View, RegistrationContract.Presenter, RegistrationFragment.RegistrationClickListener>
        implements RegistrationContract.View {

    @BindView(R.id.login_button)
    Button loginButton;

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.surname)
    EditText surname;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.confirm_password)
    EditText confirm_password;

    @BindView(R.id.registration_button)
    ImageView registrationButton;

    @OnClick(R.id.login_button)
    void onLoginButtonClick() {
        presenter.onLoginButtonClick();
    }

    @Inject
    public RegistrationFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.registration_fragment, container, false);
    }

    @Override
    public void openLoginScreen() {
        listener.onLoginClick();
    }

    public interface RegistrationClickListener {
        void onLoginClick();
    }
}
