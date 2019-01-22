package com.example.andrii.rxprojectlesson.ui.registration;

import com.example.andrii.rxprojectlesson.app.base.BaseContract;

import io.reactivex.Observable;

public interface RegistrationContract {

    interface View extends BaseContract.View {
        Observable<CharSequence> nameChangedEvent();
        Observable<CharSequence> surnameChangedEvent();
        Observable<CharSequence> emailChangedEvent();
        Observable<CharSequence> mobilePrefixChangedEvent();
        Observable<CharSequence> mobileNumberChangedEvent();
        Observable<CharSequence> passwordChangedEvent();
        Observable<CharSequence> confirmPasswordChangedEvent();
        Observable<Boolean> checkboxTopChangedEvent();
        Observable<Boolean> checkboxBottomChangedEvent();

        void setNameErrorEnabled(boolean isValid);
        void setSurnameErrorEnabled(boolean isValid);
        void setEmailErrorEnabled(boolean isValid);
        void setMobilePrefixErrorEnabled(boolean isValid);
        void setMobileNumberErrorEnabled(boolean isValid);
        void setPasswordValidationErrorEnabled(boolean isValid);
        void setPasswordDoNotMatchErrorEnabled(boolean isValid);
        void setRegisterButtonEnabled(Boolean isFieldsValid);

        void setPasswordStrengthProgressBarVisibility(boolean isValid);
        void setPasswordStrengthProgress(int strength);

        void updateMobileNumber(String mobileNumber);
    }

    interface Presenter extends BaseContract.Presenter<View>{

    }
}
