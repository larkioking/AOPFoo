package com.aopfoo.dao;

import com.aopfoo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
    private String name;
    private String serviceCode;

    public AccountDAO() {}


    public List<Account> findAccounts(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException(">>>Exception<<<");
        }

        List<Account> accounts = new ArrayList<>();

        Account temp = new Account("John", "Doe ");
        Account temp2 = new Account("Mister", "Zodiac");
        Account temp3 = new Account("April", " Ludgeit");

        accounts.add(temp);
        accounts.add(temp2);
        accounts.add(temp3);

        System.out.println("AAAAAAAAAAAAAA METHOD");
        return accounts;
    }

    public void addAccount(int one, Account account) {
        System.out.println(this.getClass() + ": DOING MY DB WORK (ADD) \n");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }
}
