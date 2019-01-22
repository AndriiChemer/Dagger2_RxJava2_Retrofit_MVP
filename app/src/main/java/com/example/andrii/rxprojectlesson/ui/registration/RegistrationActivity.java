package com.example.andrii.rxprojectlesson.ui.registration;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andrii.rxprojectlesson.app.base.BaseActivity;
import com.example.andrii.rxprojectlesson.R;
import com.jakewharton.rxbinding2.widget.RxCompoundButton;
import com.jakewharton.rxbinding2.widget.RxTextView;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;

public class RegistrationActivity
        extends BaseActivity<RegistrationContract.View, RegistrationContract.Presenter>
        implements RegistrationContract.View {

    public static void start(Context context) {
        context.startActivity(new Intent(context, RegistrationActivity.class));
    }

    @BindView(R.id.name_layout)
    TextInputLayout nameLayout;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.surname_layout)
    TextInputLayout surnameLayout;
    @BindView(R.id.surname)
    EditText surname;
    @BindView(R.id.email_layout)
    TextInputLayout emailLayout;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.prefix_phone_layout)
    TextInputLayout prefixPhoneLayout;
    @BindView(R.id.prefix_phone)
    EditText prefixPhone;
    @BindView(R.id.phone_layout)
    TextInputLayout phoneLayout;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.password_layout)
    TextInputLayout passwordLayout;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.confirm_password_layout)
    TextInputLayout confirmPasswordLayout;
    @BindView(R.id.confirm_password)
    EditText confirmPassword;
    @BindView(R.id.checkbox_top)
    CheckBox checkBoxTop;
    @BindView(R.id.checkbox_bottom)
    CheckBox checkBoxBottom;
    @BindView(R.id.password_strength)
    TextView passwordStrength;
    @BindView(R.id.progress)
    ProgressBar passwordStrengthProgress;
    @BindView(R.id.register_button)
    Button registrationButton;

    @OnClick
    void registerClick() {
        Toast.makeText(this, "Click button registration", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected int getLayoutResourceID() {
        return R.layout.registration_activity;
    }

    @Override
    public Observable<CharSequence> nameChangedEvent() {
        return RxTextView.textChanges(name)
                .skipInitialValue();
    }

    @Override
    public Observable<CharSequence> surnameChangedEvent() {
        return RxTextView.textChanges(surname)
                .skipInitialValue();
    }

    @Override
    public Observable<CharSequence> emailChangedEvent() {
        return RxTextView.textChanges(email)
                .skipInitialValue();
    }

    @Override
    public Observable<CharSequence> mobilePrefixChangedEvent() {
        return RxTextView.textChanges(prefixPhone)
                .skipInitialValue();
    }

    @Override
    public Observable<CharSequence> mobileNumberChangedEvent() {
        return RxTextView.textChanges(phone)
                .skipInitialValue();
    }

    @Override
    public Observable<CharSequence> passwordChangedEvent() {
        return RxTextView.textChanges(password)
                .skipInitialValue();
    }

    @Override
    public Observable<CharSequence> confirmPasswordChangedEvent() {
        return RxTextView.textChanges(confirmPassword)
                .skipInitialValue();
    }

    @Override
    public Observable<Boolean> checkboxTopChangedEvent() {
        return RxCompoundButton.checkedChanges(checkBoxTop);
    }

    @Override
    public Observable<Boolean> checkboxBottomChangedEvent() {
        return RxCompoundButton.checkedChanges(checkBoxBottom);
    }

    @Override
    public void setNameErrorEnabled(boolean isValid) {
        nameLayout.setError("Error");
        nameLayout.setErrorEnabled(isValid);
    }

    @Override
    public void setSurnameErrorEnabled(boolean isValid) {
        surnameLayout.setError("Error");
        surnameLayout.setErrorEnabled(isValid);
    }

    @Override
    public void setEmailErrorEnabled(boolean isValid) {
        emailLayout.setError("Error");
        emailLayout.setErrorEnabled(isValid);
    }

    @Override
    public void setMobilePrefixErrorEnabled(boolean isValid) {
        prefixPhoneLayout.setError("Error");
        prefixPhoneLayout.setErrorEnabled(isValid);
    }

    @Override
    public void setMobileNumberErrorEnabled(boolean isValid) {
        phoneLayout.setError("Error");
        phoneLayout.setErrorEnabled(isValid);
    }

    @Override
    public void setPasswordValidationErrorEnabled(boolean isValid) {
        passwordLayout.setError("Error");
        passwordLayout.setErrorEnabled(isValid);
    }

    @Override
    public void setPasswordDoNotMatchErrorEnabled(boolean isValid) {

    }

    @Override
    public void setRegisterButtonEnabled(Boolean isFieldsValid) {
        registrationButton.setEnabled(isFieldsValid);
    }

    @Override
    public void updateMobileNumber(String mobileNumber) {
        this.phone.setText(mobileNumber);
        this.phone.setSelection(mobileNumber.length());
    }

    @Override
    public void setPasswordStrengthProgressBarVisibility(boolean isVisible) {
        if (isVisible) {
            visibleProgressGroup();
        } else {
            hideProgressGroup();
        }
    }

    @Override
    public void setPasswordStrengthProgress(int percentageProgress) {
        passwordStrengthProgress.setProgress(percentageProgress);
        setProgressColor(percentageProgress);
    }

    private void setProgressColor(int percentageProgress) {
        int color;

        if (percentageProgress <= 25) {
            color = Color.RED;
        } else if(percentageProgress <= 75) {
            color = Color.YELLOW;
        } else {
            color = Color.GREEN;
        }
        passwordStrengthProgress.getProgressDrawable().setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }

    private void visibleProgressGroup() {
        passwordStrength.setVisibility(View.VISIBLE);
        passwordStrengthProgress.setVisibility(View.VISIBLE);
    }

    private void hideProgressGroup() {
        passwordStrength.setVisibility(View.GONE);
        passwordStrengthProgress.setVisibility(View.GONE);
    }
}
