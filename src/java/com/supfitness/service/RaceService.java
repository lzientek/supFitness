/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supfitness.service;

import com.supfitness.entity.Race;
import com.supfitness.entity.Track;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.supfitness.dao.RacesDao;
import com.supfitness.dao.TracksDao;
import com.supfitness.entity.Account;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author 15256
 */
@Stateless
public class RaceService {

    @EJB
    private RacesDao racesObjectDao;

    @EJB
    private TracksDao tracksObjectDao;

    public Race createRace(Race race) {
        return racesObjectDao.create(race);
    }

    public Track createTrack(Track track, Long userId) {
        if (track.getCreationDate() == null) {
            track.setCreationDate(new Date());
        }
        Race r = racesObjectDao.findLastFromUser(userId);
        Account currentUser = new Account();
        currentUser.setId(userId);
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) - 1);
        if (r == null || !cal.getTime().before(r.getCreationDate())) {
            Race nr = new Race();
            nr.setCreationDate(new Date());
            nr.setUser(currentUser);
            r = racesObjectDao.create(nr);
        }
        track.setRace(r);
        return tracksObjectDao.create(track);
    }

    public List<Track> getAllTracks() {
        return tracksObjectDao.findAll();
    }

    public List<Race> getAllObject(int page) {
        return racesObjectDao.findAll(page);
    }

    public List<Race> getAllObjectsFromUser(int page, long userId) {
        return racesObjectDao.findAllByUser(page, userId);
    }

    public double getMediumSpeed() {
        return Math.round(tracksObjectDao.getMediumSpeed() * 1000) / 1000;
    }

    /**
     * count total of user object
     *
     * @param id user id
     * @return
     */
    public Long countUsersRaces(Long id) {
        return racesObjectDao.countAllByUser(id);
    }

    public long countAll() {
        return racesObjectDao.count();
    }

    public Race find(Long id) {
        return racesObjectDao.find(id);
    }

    public void edit(Race batObj) {
        racesObjectDao.edit(batObj);
    }

    public void deleteObject(long id) {
        racesObjectDao.remove(find(id));
    }

    public Long searchCount(String search) {
        return racesObjectDao.searchCount(search);
    }

    public List<Race> search(String search, int page) {
        return racesObjectDao.search(search, page);
    }

    public void removeTrack(Long id, Long userId) throws WrongUserOrPasswordException {
        Track t = tracksObjectDao.find(id);
        if (t.getUser().getId() != userId) {
            throw new WrongUserOrPasswordException();
        }
        int trackRestant = t.getRace().getTracks().size();
        tracksObjectDao.remove(t);

        if (trackRestant <= 1) {

            racesObjectDao.removeById(t.getRace().getId());
        } 
    }

}
