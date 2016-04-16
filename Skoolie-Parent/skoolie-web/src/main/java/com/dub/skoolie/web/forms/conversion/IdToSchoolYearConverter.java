/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.forms.conversion;

import com.dub.skoolie.business.service.schedule.SchoolYearService;
import com.dub.skoolie.structures.schedule.SchoolYearBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author Kevin W
 */
public class IdToSchoolYearConverter implements Converter<String, SchoolYearBean>{
    
    @Autowired
    SchoolYearService schoolYearServiceImpl;

    @Override
    public SchoolYearBean convert(String s) {
        return schoolYearServiceImpl.getByID(Long.parseLong(s));
    }
    
}
