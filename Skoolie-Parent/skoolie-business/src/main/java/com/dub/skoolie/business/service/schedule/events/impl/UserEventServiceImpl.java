/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.schedule.events.impl;

import com.dub.skoolie.business.service.schedule.events.UserEventService;
import com.dub.skoolie.data.dao.schedule.events.UserEventRepository;
import com.dub.skoolie.data.entities.schedule.events.UserEvent;
import com.dub.skoolie.structures.schedule.events.UserEventBean;
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
public class UserEventServiceImpl implements UserEventService {
    
    @Autowired
    Mapper mapper;
    
    @Autowired
    UserEventRepository repo;

    @Override
    public UserEventBean updateEntity(UserEventBean entity) {
        UserEvent ue = new  UserEvent();
        mapper.map(entity, ue);
        ue = repo.save(ue);
        mapper.map(ue,entity);
        return entity;
    }

    @Override
    public void deleteEntity(UserEventBean entity) {
        this.deleteByID(entity.getId());
    }

    @Override
    public void deleteByID(Long id) {
        repo.delete(id);
    }

    @Override
    public UserEventBean getByID(Long id) {
        UserEventBean ueb = new UserEventBean();
        mapper.map(repo.findOne(id), ueb);
        return ueb;
    }

    @Override
    public List<UserEventBean> getAll() {
        List<UserEventBean> newlist = new ArrayList<>();
        Iterable<UserEvent> list = repo.findAll();
        for(UserEvent ue : list) {
            newlist.add(mapper.map(ue, UserEventBean.class));
        }
        return newlist;
    }
    
}
