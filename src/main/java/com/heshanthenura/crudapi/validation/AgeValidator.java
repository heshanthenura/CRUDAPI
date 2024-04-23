package com.heshanthenura.crudapi.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<ValidateAge, Integer> {
    @Override
    public void initialize(ValidateAge constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {
        try {
            Integer.parseInt(String.valueOf(age));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
