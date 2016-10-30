package com.hr.securitylab.validationClasses;

import com.hr.securitylab.database.models.DBFactory;
import com.hr.securitylab.annotations.UsernameNotInUse;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameNotInUseValidator implements ConstraintValidator<UsernameNotInUse, String>
{
    @Override
    public void initialize(UsernameNotInUse constraintAnnotation)
    {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context)
    {
        return !DBFactory.getUserService().checkUsernameExists(username);
    }
}
