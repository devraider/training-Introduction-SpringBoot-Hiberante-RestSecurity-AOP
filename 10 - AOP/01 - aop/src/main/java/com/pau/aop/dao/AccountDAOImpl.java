package com.pau.aop.dao;

import com.pau.aop.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " Account impl " + account.getName() + vipFlag);
    }
}
