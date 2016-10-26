package com.hr.securitylab.database.models.dao;

import com.hr.securitylab.database.models.entities.Product;

public interface  productDao {
    boolean checkforexitingPk(String productKey);
    boolean checkIfProductkeyIsUsed(String productKey);
    Product findProductByProductkey(String productKey);
    boolean checkIfPinIsValid(String productKey, String pin);

    void saveOrUpdate(Product product);



}
