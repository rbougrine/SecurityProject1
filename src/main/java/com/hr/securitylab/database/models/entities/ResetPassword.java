package com.hr.securitylab.database.models.entities;

import com.hr.securitylab.validationProcess.annotations.ProductKeyExists;
import com.hr.securitylab.validationProcess.annotations.ValidPassword;

import javax.validation.constraints.Size;

public class ResetPassword
{

    @ProductKeyExists
    private String productKey;

    private String pin;

    private String securityAnswer;

    private String securityQuestion;

    @Size(min = 8, max = 32)
    @ValidPassword
    private String newPassword;

    public ResetPassword()
    {
    }

    public ResetPassword(String productKey, String pin, String newPassword, String securityAnswer, String securityQuestion)
    {
        this.productKey = productKey;
        this.pin = pin;
        this.securityAnswer = securityAnswer;
        this.securityQuestion = securityQuestion;
        this.newPassword = newPassword;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
