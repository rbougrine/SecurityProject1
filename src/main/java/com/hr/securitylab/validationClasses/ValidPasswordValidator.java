package com.hr.securitylab.validationClasses;

import com.google.common.base.Joiner;
import com.hr.securitylab.annotations.ValidPassword;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class ValidPasswordValidator implements ConstraintValidator<ValidPassword, String>
{
    @Override
    public void initialize(ValidPassword arg)
    {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context)
    {
        PasswordValidator validator = new PasswordValidator
                (Arrays.asList( new UppercaseCharacterRule(1),new DigitCharacterRule(1),new WhitespaceRule()));

        RuleResult result = validator.validate(new PasswordData(password));

        if (result.isValid())
        {
            return true;
        }

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(Joiner.on(" ").join(validator.getMessages(result))).addConstraintViolation();
        return false;
    }
}
