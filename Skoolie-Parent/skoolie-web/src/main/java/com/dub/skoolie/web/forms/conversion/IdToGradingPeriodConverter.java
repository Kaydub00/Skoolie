/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.forms.conversion;

import com.dub.skoolie.business.service.schedule.GradingPeriodService;
import com.dub.skoolie.structures.schedule.GradingPeriodBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author Kevin W
 */
public class IdToGradingPeriodConverter implements Converter<String, GradingPeriodBean>{
    
    @Autowired
    GradingPeriodService gradingPeriodServiceImpl;

    @Override
    public GradingPeriodBean convert(String s) {
        return gradingPeriodServiceImpl.getByID(Long.parseLong(s));
    }
    
}
