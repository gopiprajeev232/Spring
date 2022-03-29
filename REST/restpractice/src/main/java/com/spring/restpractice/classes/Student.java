package com.spring.restpractice.classes;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String firstName, lastName;
    private boolean active;

    public Student(int id, String firstName, String lastName, boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
    }
}
