package com.project.aopdemo.dao;

import com.project.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.sql.SQLOutput;

@Repository
public class AccountDAOImp implements AccountDAO {
    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + " : DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
