package com.example.andrii.rxprojectlesson.core.validator;

import java.util.regex.Pattern;

import javax.inject.Inject;

public class EmailValidator implements Validator<String> {

    private final String validChars = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    private final Pattern pattern = Pattern.compile(validChars);

    @Inject
    public EmailValidator() {
    }

    @Override
    public boolean isValid(String data) {
        return pattern.matcher(data).matches();
    }
}
