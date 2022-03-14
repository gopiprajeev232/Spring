package com.spring.customvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BikeCodeConstraintValidator implements ConstraintValidator<BikeCode, String> {
    private String bikePrefix;

    @Override
    public void initialize(BikeCode bikeCode) {
        bikePrefix = bikeCode.value();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;

        if(code != null) {
            result = code.startsWith(bikePrefix);
        }

        else {
            result = true;
        }

        return result;
    }
}
