/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.structures.schedule.events;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Kevin W
 */
public class SchoolEventBean implements Serializable {
    
    private Long id;
    
    @NotNull
    @Size(min=2, max=140)
    private String name;
    
    @NotNull
    private Date start;
    
    @NotNull
    private Date end;
    
}
