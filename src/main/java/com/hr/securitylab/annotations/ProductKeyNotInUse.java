package com.hr.securitylab.annotations;

import com.hr.securitylab.validationClasses.ProductKeyNotInUseValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ProductKeyNotInUseValidator.class)
@Documented
public @interface ProductKeyNotInUse
{
    String message() default "Productkey is already used, please try again";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
