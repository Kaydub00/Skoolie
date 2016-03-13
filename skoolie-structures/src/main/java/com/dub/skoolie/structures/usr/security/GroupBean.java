
package com.dub.skoolie.structures.usr.security;

import java.io.Serializable;


/**
 *
 * @author Kevin W.
 */

public class GroupBean implements Serializable {

    
    private Long id;
    
    private String group;
    
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
}
