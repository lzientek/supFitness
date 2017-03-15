/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supfitness.entity;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.*;

/**
 *
 * @author 15256
 */
@Entity
@XmlRootElement
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String firstName;

    private String lastName;

    private int postalCode;

    private String email;

    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Race> races;

    @XmlTransient
    public Collection<Race> getRaces() {
        return races;
    }

    public void setRaces(Collection<Race> races) {
        this.races = races;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get crypted password
     *
     * @return
     */
        @XmlTransient
    public String getPassword() {
        return password;
    }

    /**
     * crypt the password on set
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = getMD5Hash(password);
    }

    public Boolean isPasswordValid(String passwordToCheck) {
        return getMD5Hash(passwordToCheck).equals(password);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Entities.Account[ id=" + id + " ]";
    }

    /**
     * get a hash from the password
     *
     * @param inputString
     * @return
     */
    private static String getMD5Hash(String inputString) {
        byte buf[] = inputString.getBytes();
        StringBuilder hexString = new StringBuilder();
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(buf);
            byte[] digest = algorithm.digest();
            for (int i = 0; i < digest.length; i++) {
                hexString.append(pad(Integer.toHexString(0xFF & digest[i]), 2));
            }
        } catch (Exception e) {
        }
        return hexString.toString();
    }

    private static String pad(String i, int l) {
        while (i.length() < l) {
            i = '0' + i;
        }
        return i;
    }
}
