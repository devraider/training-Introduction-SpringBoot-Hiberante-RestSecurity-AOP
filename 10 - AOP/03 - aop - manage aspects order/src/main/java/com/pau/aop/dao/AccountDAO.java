package com.pau.aop.dao;


import com.pau.aop.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean vipFlag);

    void setName(String name);

    String getName();
}
