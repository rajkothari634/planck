package com.lifegadget.planck.validators;


import com.lifegadget.planck.constants.CountryConstant;
import com.lifegadget.planck.core.utils.customAnnotations.ValidCountryName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class CountryNameValidator implements ConstraintValidator<ValidCountryName, String> {

    @Autowired
    CountryConstant countryConstant ;

    @Override
    public void initialize(ValidCountryName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && countryConstant.getCountries().contains(value) ;
    }
}