package com.hr.securitylab.database.models.dao;

import com.hr.securitylab.database.models.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Repository
public class ProductServiceImpl implements ProductService{
    private productDao productDao;

    @Autowired
    public ProductServiceImpl(productDao productDao) {
        this.productDao = productDao;
    }

    public ProductServiceImpl() {
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean checkforexitingPk(String productKey) {
        return productDao.checkforexitingPk(productKey);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean checkIfProductkeyIsUsed(String productKey) {
        return productDao.checkIfProductkeyIsUsed(productKey);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Product findProductByProductkey(String productKey) {
        return productDao.findProductByProductkey(productKey);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean checkIfPinIsValid(String productKey, String pin) {
        return productDao.checkIfPinIsValid(productKey,pin);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(Product product) {
        productDao.saveOrUpdate(product);

    }
}
