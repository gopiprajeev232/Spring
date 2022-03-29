package com.spring.joinpoint;

import com.spring.joinpoint.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        Account account = new Account();
        account.setName("Gopi");
        account.setLevel("Gold");

        accountDAO.addAccount(account, true);

        context.close();
    }
}
