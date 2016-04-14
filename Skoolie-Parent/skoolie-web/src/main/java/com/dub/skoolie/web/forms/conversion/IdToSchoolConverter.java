/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.forms.conversion;

import com.dub.skoolie.business.service.school.SchoolService;
import com.dub.skoolie.structures.school.SchoolBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author Kevin W
 */
public class IdToSchoolConverter implements Converter<String, SchoolBean>{
    
    @Autowired
    SchoolService schoolServiceImpl;

    @Override
    public SchoolBean convert(String s) {
        return schoolServiceImpl.getByID(Long.parseLong(s));
    }
    
}
