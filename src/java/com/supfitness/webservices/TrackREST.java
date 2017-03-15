/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supfitness.webservices;

import com.supfitness.entity.Account;
import com.supfitness.entity.Race;
import com.supfitness.entity.Track;
import com.supfitness.service.AccountService;
import com.supfitness.service.RaceService;
import com.supfitness.service.WrongUserOrPasswordException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author 15256
 */
@javax.ejb.Stateful
@Path("track")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TrackREST {

    @EJB
    private RaceService raceService;
    @EJB
    private AccountService accountService;

    @Context
    private HttpServletRequest request;

    private Account getActualUser() {
        Account lightAccount = new Account();
        try {
            lightAccount.setUserName(request.getParameter("username"));
            lightAccount.setPassword(request.getParameter("mdp"));
        } catch (Exception ex) {
            throw new BadRequestException("une erreur lors de la recupération de request.");
        }
        if (lightAccount.getPassword() == null || lightAccount.getUserName() == null) {
            throw new ForbiddenException("Mot de passe ou username sont maquant. Les passer en parametre de votre requete (username et mdp).");
        }

        try {
            return accountService.connectUser(lightAccount);
        } catch (WrongUserOrPasswordException ex) {
            throw new ForbiddenException("Mot de passe ou username non valide.");
        }
    }

    @GET
    @Path("{page}")
    public List<Race> get(@PathParam("page") int page) {
        Account user = getActualUser();
        return raceService.getAllObjectsFromUser(page, user.getId());
    }

    @POST
    public void create(Track entity) {
        Account user = getActualUser();
        raceService.createTrack(entity, user.getId());
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        Account user = getActualUser();
        try {
            raceService.removeTrack(id, user.getId());
        } catch (WrongUserOrPasswordException ex) {
            throw new ForbiddenException("Vous n'etes pas autorisé a supprimer cet élément.");
        }
    }

}
