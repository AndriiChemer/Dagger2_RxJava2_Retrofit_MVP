package com.example.andrii.rxprojectlesson.core.formater;

import javax.inject.Inject;

public class MobileNumberFormatter extends SeparatorFormatter {

    @Inject
    public MobileNumberFormatter() {
        super(" ", 3, 6, 3);
    }
}
