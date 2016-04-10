
package com.dub.skoolie.structures.usr.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Kevin W.
 */
public class UserBean implements Serializable {
    
    @Size(min = 6, max = 50)
    private String username;
    
    @Size(min = 8)
    private String password;
    
    @Email
    private String email;
    
    private Integer enabled;
    
    private Date expiration;
    
    private String type;
    
    private Boolean firstlogin;
    
    @Size(min = 2, max = 80)
    private String firstName;
    
    @Size(min = 2, max = 80)
    private String lastName;
    
    private List<RoleBean> roles = new ArrayList();
    
    private List<GroupBean> groups = new ArrayList();

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

    public List<RoleBean> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleBean> roles) {
        this.roles = roles;
    }
    
    public void addRole(RoleBean role) {
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
    
    public Boolean getFirstlogin() {
        return this.firstlogin;
    }
    
    public void setFirstlogin(Boolean firstlogin) {
        this.firstlogin = firstlogin;
    }
    
    public List<GroupBean> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupBean> groups) {
        this.groups = groups;
    }
    
    public void addGroup(GroupBean group) {
        this.groups.add(group);
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
