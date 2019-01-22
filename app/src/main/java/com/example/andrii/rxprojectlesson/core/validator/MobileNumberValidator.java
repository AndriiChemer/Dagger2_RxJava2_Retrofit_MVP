package com.example.andrii.rxprojectlesson.core.validator;

import javax.inject.Inject;

public class MobileNumberValidator implements Validator<String> {

    @Inject
    public MobileNumberValidator() {
    }

    @Override
    public boolean isValid(String data) {
        return data.matches("^[0-9]{8,10}");
    }
}
