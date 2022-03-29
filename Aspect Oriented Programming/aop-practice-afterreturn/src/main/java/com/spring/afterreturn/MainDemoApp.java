package com.spring.afterreturn;

import com.spring.afterreturn.dao.AccountDAO;
import com.spring.afterreturn.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        accountDAO.addAccount(new Account(), true);
        List<Account> accounts = accountDAO.findAccounts();

        System.out.println("Main method. Final result is:"+accounts);

        context.close();
    }
}
