/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.forms.conversion;
;

import com.dub.skoolie.business.service.courses.SubjectService;
import com.dub.skoolie.structures.courses.SubjectBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author kevinw
 */
public class IdToSubjectConverter implements Converter<String, SubjectBean>{
    
    @Autowired
    SubjectService subjectServiceImpl;

    @Override
    public SubjectBean convert(String s) {
        return subjectServiceImpl.getByID(Long.parseLong(s));
    }
    
    
}
