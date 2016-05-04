/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.structures.courses;

import com.dub.skoolie.structures.school.SchoolBean;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Kevin W
 */
public class SubjectBean implements Serializable {
    
    private Long id;
    
    @NotNull
    @Size(min=2, max=100)
    private String name;
    
    @NotNull
    @Size(min=2,max=10)
    private String code;
    
    @NotNull
    private String description;
    
    private SchoolBean school;
    
    private List<CourseBean> courses;

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
     * @return the school
     */
    public SchoolBean getSchool() {
        return school;
    }

    /**
     * @param school the school to set
     */
    public void setSchool(SchoolBean school) {
        this.school = school;
    }

    /**
     * @return the courses
     */
    public List<CourseBean> getCourses() {
        return courses;
    }

    /**
     * @param courses the courses to set
     */
    public void setCourses(List<CourseBean> courses) {
        this.courses = courses;
    }
    
    public void addCourse(CourseBean course) {
        this.courses.add(course);
    }
    
}
