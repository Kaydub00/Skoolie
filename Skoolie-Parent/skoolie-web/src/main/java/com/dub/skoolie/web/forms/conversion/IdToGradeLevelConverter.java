/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.forms.conversion;

import com.dub.skoolie.business.service.school.GradeLevelService;
import com.dub.skoolie.structures.school.GradeLevelBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author kevinw
 */
public class IdToGradeLevelConverter implements Converter<String, GradeLevelBean>{
    
    @Autowired
    GradeLevelService gradeLevelServiceImpl;

    @Override
    public GradeLevelBean convert(String s) {
        return gradeLevelServiceImpl.getByID(Long.parseLong(s));
    }
}
