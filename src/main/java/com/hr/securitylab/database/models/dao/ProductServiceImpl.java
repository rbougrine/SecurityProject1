package com.hr.securitylab.database.models.dao;

import com.hr.securitylab.database.models.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductServiceImpl implements ProductService
{

    private productDao productDao;

    @Autowired
    public ProductServiceImpl(productDao productDao)
    {
        this.productDao = productDao;
    }

    public ProductServiceImpl()
    {
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean checkForExitingProductKey(String productKey)
    {
        return productDao.checkForExitingProductKey(productKey);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean checkIfProductKeyIsUsed(String productKey)
    {
        return productDao.checkIfProductKeyIsUsed(productKey);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Product findProductByProductKey(String productKey)
    {
        return productDao.findProductByProductKey(productKey);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(Product product)
    {
        productDao.saveOrUpdate(product);
    }
}
