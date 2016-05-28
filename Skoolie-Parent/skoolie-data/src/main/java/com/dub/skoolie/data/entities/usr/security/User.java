
package com.dub.skoolie.data.entities.usr.security;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
    
    @Column(name="FIRST_NAME", length=80)
    private String firstName;
    
    @Column(name="LAST_NAME", length=80)
    private String lastName;
    
    @Column(name="FIRST_LOGIN")
    private Boolean firstlogin;
    
    @ManyToMany(mappedBy="users", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Role> roles;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinTable(
            name="USR_USER_GROUP",
            joinColumns = @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME"),
            inverseJoinColumns = @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP")
    )
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
