package com.spring.onlyjava;

public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "You will have a good day today :)";
    }
}
