/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supfitness.helper;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.constructorParameterOrderType;
import com.supfitness.entity.Account;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author 15256
 */
public class SessionHelper {

    public static final String ConnectedUserSession = "connectedUser";

    public static Account getSessionAccount(HttpServletRequest req) {
        return (Account) req.getSession().getAttribute(ConnectedUserSession);
    }

    public static void setSessionAccount(HttpServletRequest req, Account acc) {
        req.getSession().setAttribute(ConnectedUserSession, acc);
    }

    public static void removeSessionAccount(HttpServletRequest req) {
        req.getSession().removeAttribute(ConnectedUserSession);
    }
}
