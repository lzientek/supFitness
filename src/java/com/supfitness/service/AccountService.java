/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supfitness.service;

import com.supfitness.dao.AccountDao;
import com.supfitness.entity.Account;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 15256
 */
@Stateless
public class AccountService {

    @EJB
    private AccountDao accountDao;

    public void createAccount(Account account) {
        accountDao.create(account);
    }

    public boolean userNameExists(String userName) {
        Account user = accountDao.findByUserName(userName);
        return user != null;
    }

    /**
     * 
     * @param lightAccount only username and password filled
     * @return connected account
     * @throws WrongUserOrPasswordException 
     */
    public Account connectUser(Account lightAccount) throws WrongUserOrPasswordException {
        Account acc = accountDao.findByUserName(lightAccount.getUserName());
        if (acc == null) {
            throw new WrongUserOrPasswordException();
        }
        if (acc.getPassword().equals(lightAccount.getPassword())) {
            return acc;
        }
        throw new WrongUserOrPasswordException();
    }

    public void edit(Account account) {
        accountDao.edit(account);
    }

    public Long countAll() {
        return accountDao.count();
    }
}
