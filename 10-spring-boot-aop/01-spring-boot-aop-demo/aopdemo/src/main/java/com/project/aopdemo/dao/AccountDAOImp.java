package com.project.aopdemo.dao;

import org.springframework.stereotype.Repository;

import java.sql.SQLOutput;

@Repository
public class AccountDAOImp implements AccountDAO {
    @Override
    public void addAccount() {
        System.out.println(getClass() + " : DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
