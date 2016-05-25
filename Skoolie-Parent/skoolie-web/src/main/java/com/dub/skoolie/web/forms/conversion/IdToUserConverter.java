/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.forms.conversion;

import com.dub.skoolie.business.service.usr.security.UserService;
import com.dub.skoolie.structures.usr.security.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author Kevin W
 */
public class IdToUserConverter implements Converter<String, UserBean>{
    
    @Autowired
    UserService userServiceImpl;

    @Override
    public UserBean convert(String s) {
        return userServiceImpl.getByID(s);
    }
    
}
