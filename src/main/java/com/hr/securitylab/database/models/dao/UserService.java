package com.hr.securitylab.database.models.dao;

import com.hr.securitylab.database.models.entities.User;

public interface UserService
{
    User findUsername(String username);

    void saveOrUpdate(User user);

    boolean checkUsernameExists(String username);

}
