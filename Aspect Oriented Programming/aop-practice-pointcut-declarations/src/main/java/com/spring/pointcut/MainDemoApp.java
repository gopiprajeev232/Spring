package com.spring.pointcut;

import com.spring.pointcut.dao.AccountDAO;
import com.spring.pointcut.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        accountDAO.addAccount(new Account(), true);
        accountDAO.doWork();

        accountDAO.setName("Gopi");
        String name = accountDAO.getName();
    }
}
