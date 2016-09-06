/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.structures.schedule;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Kevin W
 */
public class GradingPeriodBean {
    
    private Long id;
    
    @NotNull
    @Size(min=2, max=40)
    private String name;
    
    @JsonBackReference
    private SchoolYearBean schoolYear;
    
    @JsonIgnore
    private List<ClassTimeBlockBean> classTimeBlocks;
    
    @NotNull
    private Date startDate;
    
    @NotNull
    private Date endDate;

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
     * @return the schoolYear
     */
    public SchoolYearBean getSchoolYear() {
        return schoolYear;
    }

    /**
     * @param schoolYear the schoolYear to set
     */
    public void setSchoolYear(SchoolYearBean schoolYear) {
        this.schoolYear = schoolYear;
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
     * @return the classTimeBlocks
     */
    public List<ClassTimeBlockBean> getClassTimeBlocks() {
        return classTimeBlocks;
    }

    /**
     * @param classTimeBlocks the classTimeBlocks to set
     */
    public void setClassTimeBlocks(List<ClassTimeBlockBean> classTimeBlocks) {
        this.classTimeBlocks = classTimeBlocks;
    }
    
}
