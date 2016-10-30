package com.hr.securitylab.database.models.dao;

import com.hr.securitylab.database.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService
{
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao)
    {
        this.userDao = userDao;
    }

    public UserServiceImpl()
    {
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User findUsername(String username)
    {
        return userDao.findUsername(username);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(User user)
    {
        userDao.saveOrUpdate(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean checkUsernameExists(String username)
    {
        return userDao.checkUsernameExists(username);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean checkIfAnswerIsValid(String productKey, String securityAnswer)
    {
        return userDao.checkIfAnswerIsValid(productKey, securityAnswer);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean checkIfQuestionIsValid(String productKey, String securityQuestion)
    {
        return userDao.checkIfQuestionIsValid(productKey, securityQuestion);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean checkIfKeyIsValid(String productKey)
    {
        return userDao.checkIfKeyIsValid(productKey);
    }
}
