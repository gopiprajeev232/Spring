package com.spring.afterfinally;

import lombok.Data;

public @Data class Account {
    private String name;
    private String level;

    public Account() {

    }

    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }
}
