/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.structures.schedule;

import com.dub.skoolie.structures.school.SchoolBean;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Kevin W
 */
public class SchoolYearBean implements Serializable {
    
    private Long id;
    
    @NotNull
    @Size(min=4, max=180)
    private String name;
    
    @NotNull
    private Date startDate;
    
    @NotNull
    private Date endDate;
    
    
    private SchoolBean school;
    
    private List<GradingPeriodBean> gradingPeriods;

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
     * @return the gradingPeriods
     */
    public List<GradingPeriodBean> getGradingPeriods() {
        return gradingPeriods;
    }

    /**
     * @param gradingPeriods the gradingPeriods to set
     */
    public void setGradingPeriods(List<GradingPeriodBean> gradingPeriods) {
        this.gradingPeriods = gradingPeriods;
    }
    
}
