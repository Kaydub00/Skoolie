
package com.dub.skoolie.structures.usr.security;

import java.io.Serializable;

/**
 *
 * @author Kevin W.
 */
public class UserRoleBean implements Serializable {

    private Long id;
    
    private UserBean user;
    
    private RoleBean role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public RoleBean getRole() {
        return role;
    }

    public void setRole(RoleBean role) {
        this.role = role;
    }
}
