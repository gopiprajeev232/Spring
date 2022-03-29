package com.spring.aroundadvice.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addAccount() {
        System.out.println("Add account method of Membership DAO");
    }
}
