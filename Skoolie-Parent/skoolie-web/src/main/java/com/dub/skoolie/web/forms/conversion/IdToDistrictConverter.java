/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.forms.conversion;

import com.dub.skoolie.business.service.district.DistrictService;
import com.dub.skoolie.structures.district.DistrictBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author Kevin W
 */
public class IdToDistrictConverter implements Converter<String, DistrictBean>{
    
    @Autowired
    DistrictService districtServiceImpl;

    @Override
    public DistrictBean convert(String s) {
        return districtServiceImpl.getByID(Long.parseLong(s));
    }
    
}
