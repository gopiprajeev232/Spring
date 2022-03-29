package com.spring.pointcut.dao;

import com.spring.pointcut.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    String name;

    public String getName() {
        System.out.println(getClass()+": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+": in setName()");
        this.name = name;
    }

    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass()+": doing db work... adding account.");
    }

    public void doWork() {
        System.out.println("Doing work");
    }
}
