package com.spring.onlyjava;

public class SadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "You have bad fortune today. :(";
    }
}
