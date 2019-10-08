package com.example.andrii.rxprojectlesson.ui.car.account.authorization.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.app.base.ClickableFragment;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

//ga0RGNYHvNM5d0SLGQfpQWAPGJ8= generate by console keystore
public class LoginFragment
        extends ClickableFragment<LoginContract.View, LoginContract.Presenter, LoginFragment.LoginClickListener>
        implements LoginContract.View {

    @BindView(R.id.username)
    EditText usernameInput;
    @BindView(R.id.password)
    EditText passwordInput;
    @BindView(R.id.reset_password)
    TextView resetPassword;
    @BindView(R.id.sing_in_button)
    ImageView loginButton;
    @BindView(R.id.login_button)
    LoginButton loginWithFbButton;

    private CallbackManager callbackManager;

    @Inject
    public LoginFragment() {
    }

    @OnClick(R.id.reset_password)
    void onResetPasswordClick() {
        presenter.onResetPasswordClick();
    }

    @OnClick(R.id.sing_in_button)
    void onLoginButtonClick() {
        presenter.onLoginButtonClick();
    }

    @OnClick(R.id.sing_in_fb)
    void onFacebookLoginClick() {
        presenter.onFacebookLoginClick();
    }

    @OnClick(R.id.registration_button)
    void onRegistrationButtonClick() {
        presenter.onRegistrationButtonClick();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment, container, false);
    }

    @Override
    protected void prepareView() {
        prepareFacebookLoginButton();
        setFacebookButtonListener();
    }

    private void setFacebookButtonListener() {
        callbackManager = CallbackManager.Factory.create();
        loginWithFbButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
    }

    private void prepareFacebookLoginButton() {
        loginWithFbButton.setFragment(this);
        loginWithFbButton.setReadPermissions("email", "public_profile");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void openResetPasswordScreen() {
        showNoImplementedFeatureMessage();
    }

    @Override
    public void openAccountScreen() {
        showNoImplementedFeatureMessage();
    }

    @Override
    public void singInUsingFacebook() {
        showDefaultErrorMessage();
        loginWithFbButton.performClick();
    }

    @Override
    public void openRegistrationScreen() {
        listener.openRegistrationScreen();
    }

    public interface LoginClickListener {
        void openRegistrationScreen();
    }
}
