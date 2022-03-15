package com.spring.basics;

public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "You'll have a great day today!";
    }
}
