/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.entities.schedule;

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
@Table(name = "SCHED_CLS_TIME_BLOCK")
public class ClassTimeBlock implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    
    @Column(name="NAME", length=180)
    private String name;
    
    @Column(name="START_HOUR")
    private Integer startHour;
    
    @Column(name="START_MINUTES")
    private Integer startMinute;
    
    @Column(name="END_HOUR")
    private Integer endHour;
    
    @Column(name="END_MINUTES")
    private Integer endMinute;
    
    @ManyToOne
    @JoinColumn(name="GRADING_PERIOD_ID")
    private GradingPeriod gradingPeriod;

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
     * @return the startHour
     */
    public Integer getStartHour() {
        return startHour;
    }

    /**
     * @param startHour the startHour to set
     */
    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }

    /**
     * @return the startMinute
     */
    public Integer getStartMinute() {
        return startMinute;
    }

    /**
     * @param startMinute the startMinute to set
     */
    public void setStartMinute(Integer startMinute) {
        this.startMinute = startMinute;
    }

    /**
     * @return the endHour
     */
    public Integer getEndHour() {
        return endHour;
    }

    /**
     * @param endHour the endHour to set
     */
    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }

    /**
     * @return the endMinutes
     */
    public Integer getEndMinute() {
        return endMinute;
    }

    /**
     * @param endMinutes the endMinutes to set
     */
    public void setEndMinute(Integer endMinute) {
        this.endMinute = endMinute;
    }

    /**
     * @return the gradingPeriod
     */
    public GradingPeriod getGradingPeriod() {
        return gradingPeriod;
    }

    /**
     * @param gradingPeriod the gradingPeriod to set
     */
    public void setGradingPeriod(GradingPeriod gradingPeriod) {
        this.gradingPeriod = gradingPeriod;
    }
    
}
