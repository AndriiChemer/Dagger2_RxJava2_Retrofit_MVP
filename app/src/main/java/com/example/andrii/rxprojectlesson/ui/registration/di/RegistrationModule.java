package com.example.andrii.rxprojectlesson.ui.registration.di;

import com.example.andrii.rxprojectlesson.core.formater.Formatter;
import com.example.andrii.rxprojectlesson.core.formater.MobileNumberFormatter;
import com.example.andrii.rxprojectlesson.core.validator.EmailValidator;
import com.example.andrii.rxprojectlesson.core.validator.InputNotEmptyValidator;
import com.example.andrii.rxprojectlesson.core.validator.MobileNumberValidator;
import com.example.andrii.rxprojectlesson.core.validator.PasswordValidator;
import com.example.andrii.rxprojectlesson.core.validator.Validator;
import com.example.andrii.rxprojectlesson.ui.registration.RegistrationContract;
import com.example.andrii.rxprojectlesson.ui.registration.RegistrationPresenter;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RegistrationModule {

    @Binds
    abstract RegistrationContract.Presenter providePresenter(RegistrationPresenter presenter);

    @Binds
    @Named("inputNotEmptyValidator")
    abstract Validator<String> provideInputNotEmptyValidator(InputNotEmptyValidator validator);

    @Binds
    @Named("mobileNumberValidator")
    abstract Validator<String> provideMobileNumberValidator(MobileNumberValidator validator);

    @Binds
    @Named("emailValidator")
    abstract Validator<String> provideEmailValidator(EmailValidator validator);

    @Binds
    @Named("passwordValidator")
    abstract Validator<String> providePasswordValidator(PasswordValidator validator);

    @Binds
    @Named("mobileNumberFormatter")
    abstract Formatter provideMobileNumberFormatter(MobileNumberFormatter mobileNumberFormatter);
}
