package com.project.aopdemo.dao;

import com.project.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccounts(boolean tripWire);
    // add a new method: findAccounts()
    List<Account> findAccounts();

    void addAccount(Account theAccount, boolean vipFlag);

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);


}
