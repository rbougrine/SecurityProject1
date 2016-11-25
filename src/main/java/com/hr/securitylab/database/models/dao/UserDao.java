package com.hr.securitylab.database.models.dao;

import com.hr.securitylab.database.models.entities.User;

public interface UserDao
{
    User findUsername(String username);

    void saveOrUpdate(User user);

    boolean checkUsernameExists(String username);

    boolean checkIfAnswerIsValid(String productKey, String securityAnswer);

    boolean checkIfQuestionIsValid(String productKey, String securityAnswer);

    boolean checkIfKeyIsValid(String productKey);
}

