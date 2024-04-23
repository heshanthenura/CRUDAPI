package com.heshanthenura.crudapi.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AgeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateAge {
    String message() default "Invalid age format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
