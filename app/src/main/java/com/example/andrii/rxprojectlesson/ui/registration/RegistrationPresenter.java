package com.example.andrii.rxprojectlesson.ui.registration;

import com.example.andrii.rxprojectlesson.app.base.BasePresenter;
import com.example.andrii.rxprojectlesson.core.formater.Formatter;
import com.example.andrii.rxprojectlesson.core.scheduler.SchedulerProvider;
import com.example.andrii.rxprojectlesson.core.validator.PasswordValidator;
import com.example.andrii.rxprojectlesson.core.validator.Validator;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function5;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class RegistrationPresenter extends BasePresenter<RegistrationContract.View>
        implements RegistrationContract.Presenter {

    private static final int DEBOUNCE_TIMEOUT_IN_MILLIS = 100;

    private Validator<String> inputNotEmptyValidator;
    private Validator<String> emailValidator;
    private Validator<String> mobileNumberValidator;
    private PasswordValidator passwordValidator;

    private SchedulerProvider schedulerProvider;

    private final Subject<Boolean> personalDataSubject = PublishSubject.create();
    private final Subject<Boolean> passwordSubject = PublishSubject.create();
    private final Subject<Boolean> checkboxesSubject = PublishSubject.create();

    private Formatter mobileNumberFormatter;

    @Inject
    RegistrationPresenter(
            @Named("inputNotEmptyValidator") Validator<String> inputNotEmptyValidator,
            @Named("emailValidator") Validator<String> emailValidator,
            @Named("mobileNumberValidator") Validator<String> mobileNumberValidator,
            @Named("mobileNumberFormatter") Formatter mobileNumberFormatter,
            PasswordValidator passwordValidator,
            SchedulerProvider schedulerProvider
    ) {
        this.inputNotEmptyValidator = inputNotEmptyValidator;
        this.emailValidator = emailValidator;
        this.mobileNumberValidator = mobileNumberValidator;
        this.mobileNumberFormatter = mobileNumberFormatter;
        this.passwordValidator = passwordValidator;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    protected void onViewAttach() {
        handleSubjectEvents();
        handlePersonalDataValidationChangeEvents();
        handlePasswordsMatchChangedEvent();
        handleCheckboxesChangedEvent();
    }

    //===========================All Dates for button==========================================

    private void handleSubjectEvents() {
        doOnView(view -> collect(
                Observable.combineLatest(
                        personalDataSubject,
                        passwordSubject,
                        checkboxesSubject,
                        (isPersonalDataValid, isPasswordValid, isCheckboxesClicked)
                                -> isPersonalDataValid && isPasswordValid && isCheckboxesClicked)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(view::setRegisterButtonEnabled, System.err::println)
        ));
    }

    //===========================Personal Data==========================================
    private void handlePersonalDataValidationChangeEvents() {
        doOnView(view -> collect(
                Observable.combineLatest(
                        prepareNameValidationObservable(view),
                        prepareSurnameValidationObservable(view),
                        preparePrefixValidationObservable(view),
                        prepareMobileNumberValidationObservable(view),
                        prepareEmailValidationObservable(view),
                        (Function5<Boolean, Boolean, Boolean, Boolean, Boolean, Boolean>) (isNameValid, isSurnameValid, isPrefixMobileValid, isMobileNumberValid, isEmailValid) ->
                                isNameValid && isSurnameValid && isPrefixMobileValid && isMobileNumberValid && isEmailValid)
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .subscribe((Consumer<Boolean>) personalDataSubject::onNext, System.err::println)
        ));
    }

    private Observable prepareNameValidationObservable(RegistrationContract.View view) {
        return view.nameChangedEvent()
                .debounce(DEBOUNCE_TIMEOUT_IN_MILLIS, TimeUnit.MILLISECONDS)
                .map(CharSequence::toString)
                .map(inputNotEmptyValidator::isValid)
                .observeOn(schedulerProvider.ui())
                .doOnNext(isValid -> view.setNameErrorEnabled(!isValid));
    }

    private Observable prepareSurnameValidationObservable(RegistrationContract.View view) {
        return view.surnameChangedEvent()
                .debounce(DEBOUNCE_TIMEOUT_IN_MILLIS, TimeUnit.MILLISECONDS)
                .map(CharSequence::toString)
                .map(inputNotEmptyValidator::isValid)
                .observeOn(schedulerProvider.ui())
                .doOnNext(isValid -> view.setSurnameErrorEnabled(!isValid));
    }

    private Observable preparePrefixValidationObservable(RegistrationContract.View view) {
        return view.mobilePrefixChangedEvent()
                .debounce(DEBOUNCE_TIMEOUT_IN_MILLIS, TimeUnit.MILLISECONDS)
                .map(CharSequence::toString)
                .map(inputNotEmptyValidator::isValid)
                .observeOn(schedulerProvider.ui())
                .doOnNext(isValid -> view.setMobilePrefixErrorEnabled(!isValid));
    }

    private Observable prepareMobileNumberValidationObservable(RegistrationContract.View view) {
        return view.mobileNumberChangedEvent()
                .map(CharSequence::toString)
                .distinctUntilChanged()
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        view.updateMobileNumber(mobileNumberFormatter.format(s));
                    }
                })
                .map(s -> s.replace(" ", ""))
                .map(mobileNumberValidator::isValid)
                .doOnNext(isValid -> view.setMobileNumberErrorEnabled(!isValid));
    }

    private Observable prepareEmailValidationObservable(RegistrationContract.View view) {
        return view.emailChangedEvent()
                .debounce(DEBOUNCE_TIMEOUT_IN_MILLIS, TimeUnit.MILLISECONDS)
                .map(CharSequence::toString)
                .map(emailValidator::isValid)
                .observeOn(schedulerProvider.ui())
                .doOnNext(isValid -> view.setEmailErrorEnabled(!isValid));
    }

    //===========================Password==========================================

    private void handlePasswordsMatchChangedEvent() {
        doOnView(view -> collect(
                Observable.combineLatest(
                        preparePasswordValidationObservable(view),
                        prepareConfirmPasswordChangedEventObservable(view),
                        (password, confirmPassword) -> password.equals(confirmPassword)
                                && inputNotEmptyValidator.isValid(password)
                                && inputNotEmptyValidator.isValid(confirmPassword)
                )
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .subscribe(isPasswordValid -> {
                    view.setPasswordDoNotMatchErrorEnabled(!isPasswordValid);
                    passwordSubject.onNext(isPasswordValid);
                }, System.err::println)
        ));
    }

    private Observable<String> preparePasswordValidationObservable(RegistrationContract.View view) {
        return view.passwordChangedEvent()
                .debounce(DEBOUNCE_TIMEOUT_IN_MILLIS, TimeUnit.MILLISECONDS)
                .map(CharSequence::toString)
                .map(password -> {
                    boolean isValid = passwordValidator.isValid(password);
                    int strength = passwordValidator.getPercentageStrength(password);
                    return new PasswordValidator.PasswordValidationResult(password, isValid, strength);
                })
                .observeOn(schedulerProvider.ui())
                .doOnNext(RegistrationPresenter.this::onPasswordChanged)
                .map(PasswordValidator.PasswordValidationResult::getPassword);
    }

    private void onPasswordChanged(PasswordValidator.PasswordValidationResult result) {
        doOnView(view -> {
            view.setPasswordValidationErrorEnabled(!result.isValid());
            view.setPasswordStrengthProgressBarVisibility(inputNotEmptyValidator.isValid(result.getPassword()));
            view.setPasswordStrengthProgress(result.getStrength());
        });
    }

    private Observable<String> prepareConfirmPasswordChangedEventObservable(RegistrationContract.View view) {
        return view.confirmPasswordChangedEvent()
                .debounce(DEBOUNCE_TIMEOUT_IN_MILLIS, TimeUnit.MILLISECONDS)
                .map(CharSequence::toString);
    }

    //===========================Checkboxes==========================================

    private void handleCheckboxesChangedEvent() {
        doOnView(view -> collect(
                Observable.combineLatest(
                        view.checkboxTopChangedEvent(),
                        view.checkboxBottomChangedEvent(),
                        (checkboxTopChecked, checkboxBottomChecked)
                                -> checkboxTopChecked && checkboxBottomChecked)
                .subscribe(checkboxesSubject::onNext, System.err::println))
        );
    }
}
