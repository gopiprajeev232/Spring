package com.spring.afterreturn.dao;

import com.spring.afterreturn.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass()+": doing db work... adding account.");
    }

    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account("Gopi Prajeev", "Diamond"));
        accounts.add(new Account("Pavan Ganesh", "Silver"));
        accounts.add(new Account("Krishna Chaitanya", "Gold"));

        return accounts;
    }

    public void doWork() {
        System.out.println("Doing work");
    }
}
