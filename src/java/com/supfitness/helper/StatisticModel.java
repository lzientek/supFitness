/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supfitness.helper;

/**
 *
 * @author 15256
 */
public class StatisticModel {

    private Long nbInscrit;
    private Long nbRace;

    private double mediumSpeed;

    public Long getNbInscrit() {
        return nbInscrit;
    }

    public void setNbInscrit(Long nbInscrit) {
        this.nbInscrit = nbInscrit;
    }

    public Long getNbRace() {
        return nbRace;
    }

    public void setNbRace(Long nbRace) {
        this.nbRace = nbRace;
    }

    public double getMediumSpeed() {
        return mediumSpeed;
    }

    public void setMediumSpeed(double mediumSpeed) {
        this.mediumSpeed = mediumSpeed;
    }

}
