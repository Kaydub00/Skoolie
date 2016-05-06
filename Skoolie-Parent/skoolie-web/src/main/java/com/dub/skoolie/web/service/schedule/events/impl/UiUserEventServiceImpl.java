/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.schedule.events.impl;

import com.dub.skoolie.business.service.schedule.events.UserEventService;
import com.dub.skoolie.structures.schedule.events.UserEventBean;
import com.dub.skoolie.web.service.schedule.events.UiUserEventService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiUserEventServiceImpl implements UiUserEventService {
    
    @Autowired
    UserEventService userEventServiceImpl;

    @Override
    public List<UserEventBean> getUserEvents() {
        return userEventServiceImpl.getAll();
    }

    @Override
    public void updateUserEvent(UserEventBean ue) {
        userEventServiceImpl.updateEntity(ue);
    }

    @Override
    public void addUserEvent(UserEventBean ue) {
        userEventServiceImpl.updateEntity(ue);
    }

    @Override
    public UserEventBean getUserEvent(Long id) {
        return userEventServiceImpl.getByID(id);
    }

    @Override
    public void deleteUserEvent(Long id) {
        userEventServiceImpl.deleteByID(id);
    }
    
}
