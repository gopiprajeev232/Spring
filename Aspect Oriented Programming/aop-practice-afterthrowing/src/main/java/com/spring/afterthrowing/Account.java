package com.spring.afterthrowing;

import lombok.Getter;
import lombok.Setter;

public class Account {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String level;

    public Account() {

    }

    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }
}
