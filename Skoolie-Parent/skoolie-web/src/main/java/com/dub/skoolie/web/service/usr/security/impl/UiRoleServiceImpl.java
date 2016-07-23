/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.usr.security.impl;

import com.dub.skoolie.business.service.usr.security.RoleService;
import com.dub.skoolie.structures.usr.security.RoleBean;
import com.dub.skoolie.web.service.usr.security.UiRoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevinw
 */
@Service
public class UiRoleServiceImpl implements UiRoleService {
    
    @Autowired
    RoleService roleServiceImpl;

    @Override
    public List<RoleBean> getRoles() {
        return roleServiceImpl.getAllRoles();
    }
    
    
}
