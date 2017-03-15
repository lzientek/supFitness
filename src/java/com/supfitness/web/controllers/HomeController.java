package com.supfitness.web.controllers;

import com.supfitness.helper.StatisticModel;
import com.supfitness.service.AccountService;
import com.supfitness.service.RaceService;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@Named("homeController")
@RequestScoped
public class HomeController extends ControllerHelper {

    private StatisticModel current;
    @EJB
    private RaceService raceService;
    
    @EJB
    private AccountService accountService;

    public HomeController() {
    }

    public StatisticModel getSelected() {
        if (current == null) {
            current = new StatisticModel();
            current.setNbInscrit(accountService.countAll());
            current.setNbRace(raceService.countAll());
            current.setMediumSpeed(raceService.getMediumSpeed());
        }
        return current;
    }

}
