/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.structures.usr.security;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author kevinw
 */
public class PasswordResetTokenBean implements Serializable {
    
    private Long id;

    private UserBean user;
    
    private String resetToken;
    
    private Date expiration;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the user
     */
    public UserBean getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UserBean user) {
        this.user = user;
    }

    /**
     * @return the resetToken
     */
    public String getResetToken() {
        return resetToken;
    }

    /**
     * @param resetToken the resetToken to set
     */
    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    /**
     * @return the expiration
     */
    public Date getExpiration() {
        return expiration;
    }

    /**
     * @param expiration the expiration to set
     */
    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
    
}
