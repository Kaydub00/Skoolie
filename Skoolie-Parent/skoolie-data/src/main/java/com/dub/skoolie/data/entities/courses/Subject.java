/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.entities.courses;

import com.dub.skoolie.data.entities.school.School;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
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
@Table(name = "CRS_SUBJECTS")
public class Subject implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name="NAME", length=100)
    private String name;    
    
    @Column(name="DESCRIPTION", length=500)
    private String description;
    
    @Column(name="CODE", length=20)
    private String code;
    
    @ManyToOne
    @JoinColumn(name="SCHOOL_ID")
    private School school;
    
    @OneToMany(mappedBy="subject")
    private List<Course> courses;

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
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the school
     */
    public School getSchool() {
        return school;
    }

    /**
     * @param school the school to set
     */
    public void setSchool(School school) {
        this.school = school;
    }

    /**
     * @return the courses
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * @param courses the courses to set
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    
    public void addCourse(Course course) {
        this.courses.add(course);
    }
    
}
