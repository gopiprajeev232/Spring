package com.thymeleaf.tables.entity;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private String firstName, lastName, email;

    public Employee() {

    }

    public Employee(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
