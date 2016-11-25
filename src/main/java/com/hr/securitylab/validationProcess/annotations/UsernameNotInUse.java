package com.hr.securitylab.validationProcess.annotations;

import com.hr.securitylab.validationProcess.validationClasses.UsernameNotInUseValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = UsernameNotInUseValidator.class)
@Documented
public @interface UsernameNotInUse
{
    String message() default "Username is already used, please try again";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

