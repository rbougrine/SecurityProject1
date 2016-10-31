package com.hr.securitylab.validationProcess.annotations;

import com.hr.securitylab.validationProcess.validationClasses.ValidPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = ValidPasswordValidator.class)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface ValidPassword
{

    String message() default "Wrong password, please try again";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
