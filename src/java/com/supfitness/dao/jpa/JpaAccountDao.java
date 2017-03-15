/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supfitness.dao.jpa;

import com.supfitness.dao.AbstractManager;
import com.supfitness.dao.AccountDao;
import com.supfitness.entity.Account;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author 15256
 */
@Stateless
public class JpaAccountDao extends AbstractManager<Account> implements AccountDao {

    @PersistenceContext(unitName = "SupFitnessPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JpaAccountDao() {
        super(Account.class);
    }

    @Override
    public Account findByUserName(String userName) {
        TypedQuery<Account> query = em.createQuery("SELECT a FROM Account AS a WHERE a.userName = :u", Account.class);
        try {
            return query.setParameter("u", userName).getSingleResult();
        } catch (NoResultException ex) {
            return null;//return null if no result
        }
    }

}
