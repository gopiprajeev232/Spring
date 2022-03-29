package com.spring.aop.dao;

import com.spring.aop.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass()+": doing db work... adding account.");
    }

    public void doWork() {
        System.out.println("Doing work");
    }
}
