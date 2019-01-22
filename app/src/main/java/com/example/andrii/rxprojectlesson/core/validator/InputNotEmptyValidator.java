package com.example.andrii.rxprojectlesson.core.validator;

import javax.inject.Inject;

public class InputNotEmptyValidator implements Validator<String> {

    @Inject
    public InputNotEmptyValidator() {
    }

    @Override
    public boolean isValid(String data) {
        return !data.isEmpty();
    }
}
