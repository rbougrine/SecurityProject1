package com.hr.securitylab.validationClasses;

import com.hr.securitylab.annotations.SamePassword;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SamePasswordValidator implements ConstraintValidator<SamePassword, Object>
{
    private String firstPassword;
    private String secondPassword;

    @Override
    public void initialize(final SamePassword constraintAnnotation)
    {
        firstPassword = constraintAnnotation.first();
        secondPassword = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context)
    {
        try
        {
            final Object firstObj = BeanUtils.getProperty(value, firstPassword);
            final Object secondObj = BeanUtils.getProperty(value, secondPassword);

            return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        }
        catch (final Exception ex)
        {
            System.out.print("Same password validation error:"+ ex);
        }
        return true;
    }
}