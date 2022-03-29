package com.rest.main;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    private int id;
    private String firstName, lastName;
    private boolean active;
    private Address address;
    private String[] languages;

    public Student() {

    }
}
