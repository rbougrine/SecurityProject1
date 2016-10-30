package com.hr.securitylab.database.models.dao;

import com.hr.securitylab.database.models.entities.Product;

public interface ProductService
{
    boolean checkForExitingProductKey(String productKey);
    boolean checkIfProductKeyIsUsed(String productKey);
    Product findProductByProductKey(String productKey);

    void saveOrUpdate(Product product);
}




