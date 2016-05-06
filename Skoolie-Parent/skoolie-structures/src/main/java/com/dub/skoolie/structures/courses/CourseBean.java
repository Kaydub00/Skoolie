/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.structures.courses;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Kevin W
 */
public class CourseBean implements Serializable {
    
    private Long id;
    
    @NotNull
    @Size(min=2, max=100)
    private String name;
    
    @NotNull
    private SubjectBean subject;
    
    @NotNull
    private String description;
    
    private List<SchoolClassBean> schoolClasses;

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
     * @return the subject
     */
    public SubjectBean getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(SubjectBean subject) {
        this.subject = subject;
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
     * @return the schoolClasses
     */
    public List<SchoolClassBean> getSchoolClasses() {
        return schoolClasses;
    }

    /**
     * @param schoolClasses the schoolClasses to set
     */
    public void setSchoolClasses(List<SchoolClassBean> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }
    
    public void addSchoolClass(SchoolClassBean schoolClass) {
        this.schoolClasses.add(schoolClass);
    }
    
}
