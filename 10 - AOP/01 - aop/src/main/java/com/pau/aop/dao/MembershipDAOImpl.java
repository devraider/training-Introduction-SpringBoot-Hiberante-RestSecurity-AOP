package com.pau.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {


    @Override
    public void addAccount() {
        System.out.println(getClass()+"Membership account added");

    }

    @Override
    public void goToSleep() {
        System.out.println(getClass()+"Going to sleep!");
    }
}
