/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supfitness.dao;

import com.supfitness.entity.Account;

/**
 *
 * @author 15256
 */
public interface AccountDao {

    public Account create(Account account);

    public void edit(Account account);

    public Account find(Object id);

    public Account findByUserName(String userName);

    public long count();

}
