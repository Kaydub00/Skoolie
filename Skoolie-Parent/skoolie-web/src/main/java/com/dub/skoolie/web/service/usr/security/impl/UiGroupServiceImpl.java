/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.usr.security.impl;

import com.dub.skoolie.business.service.usr.security.GroupService;
import com.dub.skoolie.structures.usr.security.GroupBean;
import com.dub.skoolie.web.service.usr.security.UiGroupService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevinw
 */
@Service
public class UiGroupServiceImpl implements UiGroupService {
    
    @Autowired
    GroupService groupServiceImpl;

    @Override
    public List<GroupBean> getGroups() {
        return groupServiceImpl.getAll();
    }
    
}
