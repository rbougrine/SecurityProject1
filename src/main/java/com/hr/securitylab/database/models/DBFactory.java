package com.hr.securitylab.database.models;

import com.hr.securitylab.database.models.dao.UserService;
import com.hr.securitylab.database.models.dao.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBFactory
{
        private static final ApplicationContext context;

        private DBFactory()
        {
        }

        static
        {
            context = new ClassPathXmlApplicationContext("spring.xml");
        }

        public static UserService getUserService()
        {
            return (UserService) context.getBean("userServiceImpl");
        }

        public static ProductService getProductService()
        {
                return (ProductService) context.getBean("productServiceImpl");
        }
}
