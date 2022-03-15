package com.spring.classes;

import lombok.Data;
import lombok.Getter;

import java.util.LinkedHashMap;

public @Data class Employee {
    private String firstName;
    private String lastName;
    private String country;
    private String empPosition;
    private String[] familiarLanguages;

    private @Getter LinkedHashMap<String, String> countryOptions;

    public Employee() {
        countryOptions = new LinkedHashMap<>();

        countryOptions.put("IND", "India");
        countryOptions.put("PAK", "Pakistan");
        countryOptions.put("MYN", "Myanmar");
        countryOptions.put("BHU", "Bhutan");
    }
}
