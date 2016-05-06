/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.entities.courses;

import com.dub.skoolie.data.entities.schedule.ClassTimeBlock;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Kevin W
 */
@Entity
@Table(name = "CRS_SCHOOL_CLASSES")
public class SchoolClass implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    
    @Column(name="NAME", length=100)
    private String name;
    
    @ManyToOne
    @JoinColumn(name="COURSE_ID")
    private Course course;
    
    @ManyToOne
    @JoinColumn(name="CLASS_TIME_BLOCK_ID")
    private ClassTimeBlock classTimeBlock;

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
    public Course getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * @return the classTimeBlock
     */
    public ClassTimeBlock getClassTimeBlock() {
        return classTimeBlock;
    }

    /**
     * @param classTimeBlock the classTimeBlock to set
     */
    public void setClassTimeBlock(ClassTimeBlock classTimeBlock) {
        this.classTimeBlock = classTimeBlock;
    }
    
}
