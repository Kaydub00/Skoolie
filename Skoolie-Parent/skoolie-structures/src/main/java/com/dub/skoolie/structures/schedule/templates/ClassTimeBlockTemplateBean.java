/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.structures.schedule.templates;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Kevin W
 */
public class ClassTimeBlockTemplateBean implements Serializable {
    
    private Long id;
    
    @NotNull
    @Size(min=2, max=40)
    private String name;
    
    @Max(23)
    @Min(0)
    private Integer startHour;
    
    @Max(59)
    @Min(0)
    private Integer startMinute;
    
    @Max(23)
    @Min(0)
    private Integer endHour;
    
    @Max(59)
    @Min(0)
    private Integer endMinutes;

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
    public Integer getEndMinutes() {
        return endMinutes;
    }

    /**
     * @param endMinutes the endMinutes to set
     */
    public void setEndMinutes(Integer endMinutes) {
        this.endMinutes = endMinutes;
    }
    
}
