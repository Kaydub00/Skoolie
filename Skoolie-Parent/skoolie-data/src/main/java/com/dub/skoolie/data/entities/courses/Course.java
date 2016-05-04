/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.entities.courses;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Kevin W
 */
@Entity
@Table(name = "CRS_COURSES")
public class Course implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    
    @Column(name="NAME", length=100)
    private String name;
    
    @Column(name="DESCRIPTION", length=500)
    private String description;
    
    @ManyToOne
    @JoinColumn(name="SUBJECT_ID")
    private Subject subject;
    
    @OneToMany(mappedBy="course")
    private List<SchoolClass> schoolClasses;

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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * @return the schoolClasses
     */
    public List<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    /**
     * @param schoolClasses the schoolClasses to set
     */
    public void setSchoolClasses(List<SchoolClass> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }
    
    public void addSchoolClass(SchoolClass schoolClass) {
        this.schoolClasses.add(schoolClass);
    }
}
