package com.hr.securitylab.database.models.dao;

import com.hr.securitylab.database.models.entities.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class UserDaoImpl implements UserDao
{
    @Autowired
    private SessionFactory sessionFactory;


    public User findUsername(String username)
    {
        String hql = "FROM user u where u.username = :username";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("username", username);
        List<User> users = new ArrayList<User>();
        Optional<User> result = Optional.ofNullable((User) query.uniqueResult());
        return result.get();
    }

    @Override
    public void saveOrUpdate(User user)
    {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public boolean checkUsernameExists(String username)
    {
        String hql = "FROM user u WHERE u.username = :username";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("username",username);
        Optional<User> result = Optional.ofNullable((User) query.uniqueResult());
        return result.isPresent();
    }

}
