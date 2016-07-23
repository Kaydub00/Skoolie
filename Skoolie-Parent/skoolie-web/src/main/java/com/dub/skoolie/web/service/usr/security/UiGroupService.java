/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.usr.security;

import com.dub.skoolie.structures.usr.security.GroupBean;
import java.util.List;

/**
 *
 * @author kevinw
 */
public interface UiGroupService {
    
    public List<GroupBean> getGroups();
    
}
