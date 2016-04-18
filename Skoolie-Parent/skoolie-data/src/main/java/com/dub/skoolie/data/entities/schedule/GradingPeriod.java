/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.entities.schedule;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "SCHED_GRADING_PERIOD")
public class GradingPeriod implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    
    @Column(name="NAME", length=180)
    private String name;
    
    @Column(name="START_DATE")
    private Date startDate;
    
    @Column(name="END_DATE")
    private Date endDate;
    
    @ManyToOne
    @JoinColumn(name="SCHOOL_YEAR_ID")
    private SchoolYear schoolYear;
    
    @OneToMany(mappedBy="gradingPeriod", cascade = CascadeType.ALL)
    private List<ClassTimeBlock> classTimeBlocks;

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
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the schoolYear
     */
    public SchoolYear getSchoolYear() {
        return schoolYear;
    }

    /**
     * @param schoolYear the schoolYear to set
     */
    public void setSchoolYear(SchoolYear schoolYear) {
        this.schoolYear = schoolYear;
    }

    /**
     * @return the classTimeBlocks
     */
    public List<ClassTimeBlock> getClassTimeBlocks() {
        return classTimeBlocks;
    }

    /**
     * @param classTimeBlocks the classTimeBlocks to set
     */
    public void setClassTimeBlocks(List<ClassTimeBlock> classTimeBlocks) {
        this.classTimeBlocks = classTimeBlocks;
    }
    
    
}
