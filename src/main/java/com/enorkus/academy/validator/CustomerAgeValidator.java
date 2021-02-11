package com.enorkus.academy.validator;

import com.enorkus.academy.exception.ValidationException;


public class CustomerAgeValidator {
    public void validate(int age, String message) {
        if (age < 18) {
            throw new ValidationException(message);
        }
    }
}
