package com.hr.securitylab.database.models.entities;

import com.hr.securitylab.annotations.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@SamePassword.List({
        @SamePassword(first = "password", second = "checkPassword", message = "These passwords don't match. Try again?")
})
public class NewUser
{
    @Size(min=8, max=32)
    @UsernameNotInUse
    @NotEmpty
    @NotNull
    private String username;

    @Size(min=8, max=32)
    @NotEmpty
    @NotNull
    @ValidPassword
    private String password;

    @NotEmpty
    @NotNull
    private String checkPassword;

    @NotEmpty
    @NotNull
    private String securityAnswer;

    @NotEmpty
    @NotNull
    private String securityQuestion;

    @NotEmpty
    @NotNull
    @ProductKeyExists
    @ProductKeyNotInUse
    private String productKey;


    public NewUser()
    {
    }

    public NewUser(String username, String password, String checkPassword, String productKey, String securityAnswer, String securityQuestion)
    {
        this.username = username;
        this.password = password;
        this.checkPassword = checkPassword;
        this.productKey = productKey;
        this.securityAnswer = securityAnswer;
        this.securityQuestion = securityQuestion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getcheckPassword() {
        return checkPassword;
    }

    public void setcheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {this.securityAnswer = securityAnswer;}

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {this.securityQuestion = securityQuestion;}

}
