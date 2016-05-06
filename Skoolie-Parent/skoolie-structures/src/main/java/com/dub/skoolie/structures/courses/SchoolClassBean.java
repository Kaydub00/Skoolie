/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.structures.courses;

import com.dub.skoolie.structures.schedule.ClassTimeBlockBean;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Kevin W
 */
public class SchoolClassBean implements Serializable {
    
    private Long id;
    
    @NotNull
    @Size(min=2, max=100)
    private String name;
    
    @NotNull
    private CourseBean course;
    
    @NotNull
    private ClassTimeBlockBean classTimeBlock;

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
     * @return the course
     */
    public CourseBean getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(CourseBean course) {
        this.course = course;
    }

    /**
     * @return the classTimeBlock
     */
    public ClassTimeBlockBean getClassTimeBlock() {
        return classTimeBlock;
    }

    /**
     * @param classTimeBlock the classTimeBlock to set
     */
    public void setClassTimeBlock(ClassTimeBlockBean classTimeBlock) {
        this.classTimeBlock = classTimeBlock;
    }
    
}
