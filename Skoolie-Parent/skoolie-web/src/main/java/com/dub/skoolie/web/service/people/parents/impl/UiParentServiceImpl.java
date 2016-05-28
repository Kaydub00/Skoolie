/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.people.parents.impl;

import com.dub.skoolie.business.service.people.parents.ParentService;
import com.dub.skoolie.structures.people.parents.ParentBean;
import com.dub.skoolie.web.service.people.parents.UiParentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiParentServiceImpl implements UiParentService {
    
    @Autowired
    ParentService parentServiceImpl;

    @Override
    public List<ParentBean> getParents() {
        return parentServiceImpl.getAll();
    }

    @Override
    public ParentBean getParent(String username) {
        return parentServiceImpl.getByID(username);
    }

    @Override
    public void updateParent(ParentBean user) {
        parentServiceImpl.updateEntity(user);
    }

    @Override
    public void addParent(ParentBean user) {
        parentServiceImpl.updateEntity(user);
    }

    @Override
    public void deleteParentByUsername(String username) {
        parentServiceImpl.deleteByID(username);
    }

    @Override
    public void deleteParent(ParentBean user) {
        parentServiceImpl.deleteEntity(user);
    }
    
}
