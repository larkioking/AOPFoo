package com.aopfoo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Heavy traffic today!";
    }

    public String getFortune(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("EXCEPTION HERE");
        }
        return getFortune();
    }
}
