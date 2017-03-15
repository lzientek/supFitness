/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supfitness.dao.jpa;

import com.supfitness.dao.AbstractManager;
import com.supfitness.entity.Race;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.supfitness.dao.RacesDao;

/**
 *
 * @author 15256
 */
@Stateless
public class JpaRacesDao extends AbstractManager<Race> implements RacesDao {

    @PersistenceContext(unitName = "SupFitnessPU")
    private EntityManager em;

    public JpaRacesDao() {
        super(Race.class);
    }

    public void removeById(Long id) {
        javax.persistence.Query q = getEntityManager().createQuery("DELETE FROM Race AS r WHERE r.id= :trackid");
        q.setParameter("trackid", id);
        q.executeUpdate();

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public static final int OBJECT_PER_PAGE = 5;

    @Override
    public List<Race> findAllByUser(int page, long userId) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Race.class));
        javax.persistence.Query q = getEntityManager().createQuery("SELECT obj FROM Race AS obj WHERE OBJ.user.id = :userId ORDER BY OBJ.creationDate DESC");
        q.setParameter("userId", userId);
        q.setMaxResults(OBJECT_PER_PAGE);
        q.setFirstResult(page * OBJECT_PER_PAGE);
        return q.getResultList();
    }

    @Override
    public List<Race> findAll(int page) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Race.class));
        javax.persistence.Query q = getEntityManager().createQuery("SELECT obj FROM Race AS obj ORDER BY OBJ.creationDate DESC");
        q.setMaxResults(OBJECT_PER_PAGE);
        q.setFirstResult(page * OBJECT_PER_PAGE);
        return q.getResultList();
    }

    @Override
    public Long countAllByUser(Long id) {
        javax.persistence.Query q = getEntityManager().createQuery("SELECT COUNT(obj) FROM Race AS obj WHERE OBJ.user.id = :userId");
        q.setParameter("userId", id);
        return (Long) q.getSingleResult();
    }

    @Override
    public Long searchCount(String search) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root o = GenerateSearchRequest(cq, search, cb);
        cq.select(getEntityManager().getCriteriaBuilder().count(o));

        return (Long) getEntityManager().createQuery(cq).getSingleResult();
    }

    @Override
    public List<Race> search(String search, int page) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root o = GenerateSearchRequest(cq, search, cb);
        cq.select(o);
        TypedQuery q = getEntityManager().createQuery(cq);
        q.setMaxResults(OBJECT_PER_PAGE);
        q.setFirstResult(page * OBJECT_PER_PAGE);
        return q.getResultList();
    }

    /**
     * use criteria to generate the search
     *
     * @param cq criteria query
     * @param search search request
     * @param cb criteria builder
     * @return
     */
    private Root GenerateSearchRequest(CriteriaQuery cq, String search, CriteriaBuilder cb) {

        String[] searchWords = search.split(" ");
        Root o = cq.from(Race.class);
        List<Predicate> predicates = new ArrayList<>();
        for (String searchWord : searchWords) {
            predicates.add(cb.like(o.<String>get("description"), "%" + searchWord + "%"));
            predicates.add(cb.like(o.<String>get("name"), "%" + searchWord + "%"));
            predicates.add(cb.like(o.<String>get("price"), searchWord));
        }
        cq.where(cb.or(predicates.toArray(new Predicate[0])));
        return o;
    }

    @Override
    public Race findLastFromUser(Long id) {
        javax.persistence.Query q = getEntityManager().createQuery("SELECT obj FROM Race AS obj WHERE OBJ.user.id = :userId ORDER BY OBJ.creationDate DESC");
        q.setParameter("userId", id);
        return (Race) q.setMaxResults(1).getSingleResult();
    }

}
