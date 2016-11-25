package com.hr.securitylab.database.models;


import com.hr.securitylab.database.models.entities.NewUser;
import com.hr.securitylab.database.models.entities.Product;
import com.hr.securitylab.database.models.entities.User;
import org.springframework.validation.Errors;

import java.util.Arrays;
import java.util.HashSet;

public class RegisterDB
{

    public void showErrors(Errors errors)
    {
        System.out.println(errors.getGlobalErrors());
    }

    //password still has to be encrypted
    public void createNewAccount(NewUser newUser)
    {
        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        user.setSecurityAnswer(newUser.getSecurityAnswer());
        user.setSecurityQuestion(newUser.getSecurityQuestion());
        DBFactory.getUserService().saveOrUpdate(user);
        Product product = DBFactory.getProductService().findProductByProductKey(newUser.getProductKey());
        product.setUser(user);
        product.setActivated(true);
        user.setProducts(new HashSet<>(Arrays.asList(product)));
        DBFactory.getProductService().saveOrUpdate(product);
    }
}
