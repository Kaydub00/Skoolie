
package com.dub.skoolie.data.entities.usr.security;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Kevin W.
 */
@Entity
@Table(name = "USR_USER")
public class User implements Serializable {

    @Id
    @Column(name="USERNAME", length=50)
    private String username;
    
    @Column(name="PASSWORD")
    private String password;
    
    @Column(name="EMAIL", length=180)
    private String email;
    
    @Column(name="ENABLED")
    private Integer enabled;
    
    @Column(name="EXPIRATION")
    private Date expiration;
    
    @Column(name="TYPE", length=40)
    private String type;
    
    @Column(name="FIRST_LOGIN")
    private Boolean firstlogin;
    
    @ManyToMany(mappedBy="users", fetch = FetchType.LAZY)
    private List<Role> roles;
    
    @ManyToMany(mappedBy="users", fetch = FetchType.LAZY)
    private List<Group> groups;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
    
    public Boolean getFirstlogin() {
        return this.firstlogin;
    }
    
    public void setFirstlogin(Boolean firstlogin) {
        this.firstlogin = firstlogin;
    }
}
