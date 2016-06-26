/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.usr.security.impl;

import com.dub.skoolie.business.service.usr.security.GroupService;
import com.dub.skoolie.data.dao.usr.security.GroupRepository;
import com.dub.skoolie.data.entities.usr.security.Group;
import com.dub.skoolie.structures.usr.security.GroupBean;
import java.util.ArrayList;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kevin W
 */
@Transactional("skooliecoreTransactionManager")
@Service
public class GroupServiceImpl implements GroupService {
    
    @Autowired
    Mapper mapper;
    
    @Autowired
    GroupRepository repo;

    @Override
    public GroupBean updateEntity(GroupBean entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEntity(GroupBean entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GroupBean getByID(String id) {
        GroupBean bn = new GroupBean();
        mapper.map(repo.findOne(id), bn);
        return bn;
    }

    @Override
    public List<GroupBean> getAll() {
        List<GroupBean> newlist = new ArrayList<>();
        Iterable<Group> list = repo.findAll();
        for(Group user : list) {
            newlist.add(mapper.map(user, GroupBean.class));
        }
        return newlist;
    }
    
}
