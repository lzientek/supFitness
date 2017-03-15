package com.supfitness.web.controllers;

import com.supfitness.entity.Account;
import com.supfitness.helper.JsfUtil;
import com.supfitness.helper.SessionHelper;
import com.supfitness.service.AccountService;
import com.supfitness.service.WrongUserOrPasswordException;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@Named("accountController")
@SessionScoped
public class AccountController extends ControllerHelper {

    private Account current;
    @EJB
    private AccountService accountService;

    public AccountController() {
        super.setTitle("Account");
    }

    private AccountService getAccountService() {
        return accountService;
    }

    public String prepareView() {
        current = new Account();
        return super.getPath() +"/account/Login.xhtml";
    }

    public String login() {

        try {
            current = accountService.connectUser(current);
            SessionHelper.setSessionAccount(getHttpServletRequest(), current);
            JsfUtil.addSuccessMessage(getBundle().getString("AccountLogin"));
        } catch (WrongUserOrPasswordException ex) {
            JsfUtil.addErrorMessage(ex, getBundle().getString("WrongUserOrPassword"));
            return null;
        }

        return "success";
    }

    public String prepareCreate() {
        current = new Account();
        return super.getPath() +"account/Create.xhtml";
    }

    public String create() {
        try {
            getAccountService().createAccount(current);
            JsfUtil.addSuccessMessage(getBundle().getString("AccountCreated"));
            return prepareView();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, getBundle().getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        return super.getPath() +"account/Edit.xhtml";
    }

    public String update() {
        try {
            getAccountService().edit(current);
            JsfUtil.addSuccessMessage(getBundle().getString("AccountUpdated"));
            return super.getPath() +"Login.xhtml";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, getBundle().getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public Account getSelected() {
        return current;
    }

}
