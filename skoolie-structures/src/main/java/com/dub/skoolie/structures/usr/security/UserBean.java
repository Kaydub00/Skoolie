
package com.dub.skoolie.structures.usr.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Kevin W.
 */
public class UserBean implements Serializable {
    
    private String username;
    
    private String password;
    
    private String email;
    
    private Integer enabled;
    
    private Date expiration;
    
    private String type;
    
    private List<UserRoleBean> roles = new ArrayList();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public List<UserRoleBean> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRoleBean> roles) {
        this.roles = roles;
    }
    
    public void addRole(UserRoleBean role) {
        this.roles.add(role);
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
