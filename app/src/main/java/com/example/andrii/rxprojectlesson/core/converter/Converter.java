package com.example.andrii.rxprojectlesson.core.converter;

public interface Converter<Input, Output> {

    Output convert(Input data);
}
