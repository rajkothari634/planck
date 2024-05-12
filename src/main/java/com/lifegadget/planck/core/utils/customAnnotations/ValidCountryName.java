package com.lifegadget.planck.core.utils.customAnnotations;
import com.lifegadget.planck.constants.CountryConstant;
import com.lifegadget.planck.validators.CountryNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CountryNameValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCountryName {

    String message() default "Invalid country name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}