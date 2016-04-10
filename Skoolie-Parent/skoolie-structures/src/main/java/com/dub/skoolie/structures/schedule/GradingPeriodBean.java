/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.structures.schedule;

import java.util.Date;
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
    
    private SchoolYearBean schoolYear;
    
    @NotNull
    private Date startDate;
    
    @NotNull
    private Date endDate;
    
}
