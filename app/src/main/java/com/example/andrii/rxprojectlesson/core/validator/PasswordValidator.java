package com.example.andrii.rxprojectlesson.core.validator;

import javax.inject.Inject;

import lombok.AllArgsConstructor;
import lombok.Value;

public class PasswordValidator implements Validator<String> {

    @Inject
    public PasswordValidator() {
    }

    @Override
    public boolean isValid(String password) {
        return false;
    }

    public int getPercentageStrength(String password) {
        switch (calculateStrength(password)) {
            case 1:
                return 25;
            case 2:
                return 50;
            case 3:
                return 75;
            case 4:
                return 100;
            default:
                return 0;
        }
    }

    private int calculateStrength(String password) {
        int strength = 0;

        if (hasAtLeastOneLowercaseLetter(password)) {
            strength++;
        }
        if (hasAtLeastOneUppercaseLetter(password)) {
            strength++;
        }
        if (hasAtLeastOneDigit(password)) {
            strength++;
        }
        if (hasAtLeastSpecialCharacter(password)) {
            strength++;
        }

        if (hasAtLeastEightCharacters(password)) {
            return Math.min(3, strength) + 1;

        } else {
            return Math.min(3, strength);
        }
    }

    private boolean hasAtLeastEightCharacters(String s) {
        return s.matches("^.{8,}$");
    }

    private boolean hasAtLeastOneDigit(String s) {
        return s.matches("^.*[0-9]+.*$");
    }

    private boolean hasAtLeastOneLowercaseLetter(String s) {
        return s.matches("^.*[a-z]+.*$");
    }

    private boolean hasAtLeastOneUppercaseLetter(String s) {
        return s.matches("^.*[A-Z]+.*$");
    }

    private boolean hasAtLeastSpecialCharacter(String s) {
        return s.matches("^.*[@#$%^&+=]+.*$");
    }

    @Value
    @AllArgsConstructor
    public static class PasswordValidationResult {
        private String password;
        private boolean isValid;
        private int strength;
    }
}
