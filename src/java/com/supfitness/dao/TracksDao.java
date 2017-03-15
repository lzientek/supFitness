/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supfitness.dao;

import com.supfitness.entity.Track;
import java.util.List;

/**
 *
 * @author 15256
 */
public interface TracksDao {
    public Track create(Track obj);

    public void edit(Track obj);

    public Track find(Object obj);

    public List<Track> findAll();

    public double getMediumSpeed();

    public void remove(Track t);
    
}
