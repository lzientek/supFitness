/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supfitness.dao;

import com.supfitness.entity.Race;
import java.util.List;

/**
 *
 * @author 15256
 */
public interface RacesDao {

    public Race create(Race obj);

    public void edit(Race obj);

    public Race find(Object obj);

    public List<Race> findAllByUser(int page, long userId);

    public Long countAllByUser(Long id);

    public List<Race> findAll(int page);

    public long count();
    
    public void remove(Race entity);

    public Long searchCount(String search);

    public List<Race> search(String search, int page);


    public Race findLastFromUser(Long id);

    public void removeById(Long id);
}
