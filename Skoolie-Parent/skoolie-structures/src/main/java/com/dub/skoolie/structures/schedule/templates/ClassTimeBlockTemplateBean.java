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
    
}
