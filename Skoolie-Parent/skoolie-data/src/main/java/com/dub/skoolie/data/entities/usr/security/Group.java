
package com.dub.skoolie.data.entities.usr.security;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "USR_GROUPS")
public class Group implements Serializable {
    
    @Id
    @Column(name="GROUP", length=80)
    private String group;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade= {CascadeType.PERSIST})
    @JoinTable(
            name="USR_USER_GROUP",
            joinColumns = @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP"),
            inverseJoinColumns = @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
    )
    private List<User> users;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "USR_GROUP_ROLES",
            joinColumns = @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP"),
            inverseJoinColumns = @JoinColumn(name = "ROLE", referencedColumnName = "ROLE")
    )
    private List<Role> roles;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    
}
