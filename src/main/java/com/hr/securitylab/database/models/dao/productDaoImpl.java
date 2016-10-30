package com.hr.securitylab.database.models.dao;

import com.hr.securitylab.database.models.entities.Product;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProductDaoImpl implements productDao
{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean checkForExitingProductKey(String productKey)
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.like("productKey", productKey));
        return (Optional.ofNullable((Product) criteria.uniqueResult())).isPresent();
    }

    @Override
    public boolean checkIfProductKeyIsUsed(String productKey)
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.like("productKey", productKey));
        Optional<Product> result = Optional.ofNullable((Product) criteria.uniqueResult());
        return result.isPresent() && result.get().isActivated();
    }

    @Override
    public Product findProductByProductKey(String productKey)
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.like("productKey", productKey));
        return (Product) criteria.uniqueResult();
    }

    @Override
    public void saveOrUpdate(Product product)
    {
        sessionFactory.getCurrentSession().saveOrUpdate(product);
    }
}