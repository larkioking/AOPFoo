package com.aopfoo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    private String anotherSmth;

    public void doSomething() {
        System.out.println("Now it's new class with same method name!\n");
    }

    public String getAnotherSmth() {
        System.out.println("Another getting\n");

        return anotherSmth;
    }

    public void setAnotherSmth(String anotherSmth) {
        System.out.println("Another setting\n");
        this.anotherSmth = anotherSmth;
    }
}
