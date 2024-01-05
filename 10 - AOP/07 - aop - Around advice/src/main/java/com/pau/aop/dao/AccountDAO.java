package com.pau.aop.dao;


import com.pau.aop.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount(Account account, boolean vipFlag);

    void setName(String name);

    String getName();

    List<Account> findAccounts(boolean b);

}
