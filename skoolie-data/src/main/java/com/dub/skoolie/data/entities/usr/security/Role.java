
package com.dub.skoolie.data.entities.usr.security;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
