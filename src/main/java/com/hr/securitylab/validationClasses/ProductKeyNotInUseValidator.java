package com.hr.securitylab.validationClasses;

import com.hr.securitylab.annotations.ProductKeyNotInUse;
import com.hr.securitylab.database.models.DBFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductKeyNotInUseValidator implements ConstraintValidator<ProductKeyNotInUse, String>
{
    @Override
    public void initialize(ProductKeyNotInUse constraintAnnotation)
    {

    }

    @Override
    public boolean isValid(String productKey, ConstraintValidatorContext context)
    {
        return !DBFactory.getProductService().checkIfProductKeyIsUsed(productKey);
    }
}
