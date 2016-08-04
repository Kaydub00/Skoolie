/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.structures.school;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kevinw
 */
public class GradeLevelBean implements Serializable {
    
    private Long id;
    
    @NotNull
    @Size(max=180)
    private String name;
    
    private Long level;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the level
     */
    public Long getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(Long level) {
        this.level = level;
    }
    
}
