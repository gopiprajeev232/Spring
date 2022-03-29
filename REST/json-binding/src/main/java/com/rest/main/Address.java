package com.rest.main;

import lombok.Data;

@Data
public class Address {
    private String street, city, state, zip, country;

    public Address() {

    }
}
