/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.schedule.events.impl;

import com.dub.skoolie.business.service.schedule.events.SchoolEventService;
import com.dub.skoolie.data.dao.schedule.events.SchoolEventRepository;
import com.dub.skoolie.data.entities.schedule.events.SchoolEvent;
import com.dub.skoolie.structures.schedule.events.SchoolEventBean;
import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kevin W
 */
@Transactional("skooliecoreTransactionManager")
@Service
public class SchoolEventServiceImpl implements SchoolEventService {
    
    @Autowired
    DozerBeanMapper mapper;
    
    @Autowired
    SchoolEventRepository repo;

    @Override
    public SchoolEventBean updateEntity(SchoolEventBean entity) {
        SchoolEvent se = new  SchoolEvent();
        mapper.map(entity, se);
        se = repo.save(se);
        mapper.map(se,entity);
        return entity;
    }

    @Override
    public void deleteEntity(SchoolEventBean entity) {
        this.deleteByID(entity.getId());
    }

    @Override
    public void deleteByID(Long id) {
        repo.delete(id);
    }

    @Override
    public SchoolEventBean getByID(Long id) {
        SchoolEventBean deb = new SchoolEventBean();
        mapper.map(repo.findOne(id), deb);
        return deb;
    }

    @Override
    public List<SchoolEventBean> getAll() {
        List<SchoolEventBean> newlist = new ArrayList<>();
        Iterable<SchoolEvent> list = repo.findAll();
        for(SchoolEvent se : list) {
            newlist.add(mapper.map(se, SchoolEventBean.class));
        }
        return newlist;
    }
    
}
