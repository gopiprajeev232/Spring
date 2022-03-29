package com.spring.afterfinally;

import com.spring.afterfinally.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = null;
        try {
             accounts = accountDAO.findAccounts();
        }

        catch (Exception e) {
            System.out.println("\n===> Main block exception caught: "+e.getMessage());
        }

        System.out.println("Main method. Final result is: "+accounts);

        context.close();
    }
}
