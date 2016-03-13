
package com.dub.skoolie.data.entities.usr.security;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "USR_ROLES")
public class Role implements Serializable {
    
    
    @Id
    @Column(name="ROLE", length=20)
    private String role;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "USR_USER_ROLE",
            joinColumns = @JoinColumn(name = "ROLE", referencedColumnName = "ROLE"),
            inverseJoinColumns = @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
    )
    private List<User> users;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
