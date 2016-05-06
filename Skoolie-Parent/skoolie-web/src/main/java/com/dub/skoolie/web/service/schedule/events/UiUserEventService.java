/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.schedule.events;

import com.dub.skoolie.structures.schedule.events.UserEventBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiUserEventService {
    
    public List<UserEventBean> getUserEvents();
    
    public void updateUserEvent(UserEventBean ue);
    
    public void addUserEvent(UserEventBean ue);
    
    public UserEventBean getUserEvent(Long id);
    
    public void deleteUserEvent(Long id);
    
}
