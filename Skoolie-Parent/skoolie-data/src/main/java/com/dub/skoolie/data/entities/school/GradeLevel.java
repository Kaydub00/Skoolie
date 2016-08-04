/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.entities.school;

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
 * @author kevinw
 */
@Entity
@Table(name = "GRADE_LEVELS")
public class GradeLevel implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    
    @Column(name="NAME", length=180)
    private String name;
    
    @Column(name="GRADE_LEVEL")
    private Long level;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinTable(
            name="SCL_GRADE_LEVELS",
            joinColumns = @JoinColumn(name = "GRADE_LEVEL_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "SCHOOL_ID", referencedColumnName = "ID")
    )
    private List<School> schools;

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
