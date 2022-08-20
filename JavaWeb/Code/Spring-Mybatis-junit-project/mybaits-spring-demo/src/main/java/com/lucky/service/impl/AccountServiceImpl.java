package com.lucky.service.impl;

import com.lucky.dao.AccountDao;
import com.lucky.domain.Account;
import com.lucky.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    //自动装配对象
    @Autowired
    private AccountDao accountDao;

    public void save(Account account) {accountDao.save(account);}

    public void delete(Integer id) {accountDao.delete(id);}

    public void update(Account account) {accountDao.update(account);}

    public List<Account> findAll() {return accountDao.findAll();}

    public Account findById(Integer id) {
        return accountDao.findById(id);
    }
}
