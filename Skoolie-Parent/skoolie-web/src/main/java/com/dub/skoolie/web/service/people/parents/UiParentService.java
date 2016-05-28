/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.people.parents;

import com.dub.skoolie.structures.people.parents.ParentBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiParentService {
    
    public List<ParentBean> getParents();
    
    public ParentBean getParent(String username);
    
    public void updateParent(ParentBean user);
    
    public void addParent(ParentBean user);
    
    public void deleteParentByUsername(String username);
    
    public void deleteParent(ParentBean user);
    
}
