/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supfitness.web.controllers;

import com.supfitness.entity.Account;
import com.supfitness.helper.SessionHelper;
import java.io.Serializable;
import java.security.Principal;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author 15256
 */
@ManagedBean
@Named("globalController")
public class ControllerHelper implements Serializable {

    private String title;

    public ControllerHelper() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ResourceBundle getBundle() {
        return ResourceBundle.getBundle("/Bundle");
    }

    public Boolean isConnected() {
        return SessionHelper.getSessionAccount(getHttpServletRequest()) != null;
    }

    public Account getConnectedAccount() {
        return SessionHelper.getSessionAccount(getHttpServletRequest());
    }

    public HttpServletRequest getHttpServletRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public String getPath() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    }

    public void addErrorMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getRequestParam(String paramName) {
        return getHttpServletRequest().getParameter(paramName);
    }

    public String logout() {
        SessionHelper.removeSessionAccount(getHttpServletRequest());
        return "login";
    }
}
