package com.hr.securitylab.database.models.dao;

import com.hr.securitylab.database.models.entities.Product;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class  productDaoImpl implements productDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean checkforexitingPk(String productKey) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.like("productkey", productKey));
        return (Optional.ofNullable((Product) criteria.uniqueResult())).isPresent();
    }

    @Override
    public boolean checkIfProductkeyIsUsed(String productKey) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.like("productkey", productKey));
        Optional<Product> result = Optional.ofNullable((Product) criteria.uniqueResult());
        return result.isPresent() && result.get().isActivated();
    }

    @Override
    public Product findProductByProductkey(String productKey) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.like("productkey", productKey));
        return (Product) criteria.uniqueResult();
    }

    @Override
    public boolean checkIfPinIsValid(String productKey, String pin) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.like("productkey", productKey));
        Optional<Product> result = Optional.ofNullable((Product) criteria.uniqueResult());
        return result.isPresent() && result.get().getPin().equals(pin);
    }

    @Override
    public void saveOrUpdate(Product product) {
        sessionFactory.getCurrentSession().saveOrUpdate(product);

    }
}