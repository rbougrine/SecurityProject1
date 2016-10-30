package com.hr.securitylab.database.models.dao;

import com.hr.securitylab.database.models.entities.Product;
import com.hr.securitylab.database.models.entities.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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


    @Override
    public boolean checkIfAnswerIsValid(String productKey, String securityAnswer)
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.like("productKey", productKey));
        Optional<User> result = Optional.ofNullable((User) criteria.uniqueResult());
        return result.isPresent() && result.get().getSecurityAnswer().equals(securityAnswer);
    }

    @Override
    public boolean checkIfQuestionIsValid(String productKey, String securityQuestion)
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.like("productKey", productKey));
        Optional<User> result = Optional.ofNullable((User) criteria.uniqueResult());
        return result.isPresent() && result.get().getSecurityQuestion().equals(securityQuestion);
    }

    @Override
    public boolean checkIfKeyIsValid(String productKey)
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.like("productKey", productKey));
        Optional<Product> result = Optional.ofNullable((Product) criteria.uniqueResult());
        return result.isPresent() && result.get().getproductKey().equals(productKey);
    }


}
