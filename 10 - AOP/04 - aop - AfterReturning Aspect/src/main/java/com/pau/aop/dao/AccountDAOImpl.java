package com.pau.aop.dao;

import com.pau.aop.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " Account impl " + account.getName() + vipFlag);
    }

    @Override
    public void setName(String name) {
        System.out.println("New name "+name + "\n\n\n\n");
    }

    @Override
    public String getName() {
        System.out.println("Getter of name "+ "\n\n\n\n");
        return "Some name";
    }

    @Override
    public List<Account> findAccounts() {
        List<Account> a = new ArrayList<>();
        a.add(new Account("s", "d"));
        return a;
    }
}
