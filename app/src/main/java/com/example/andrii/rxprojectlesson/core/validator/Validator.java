package com.example.andrii.rxprojectlesson.core.validator;

public interface Validator<T> {
    boolean isValid(T data);
}
