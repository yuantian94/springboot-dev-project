package com.project.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImp implements MembershipDAO{


    @Override
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
    }

    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A SILLY MEMBERSHIP ACCOUNT");
        return true;
    }
}
