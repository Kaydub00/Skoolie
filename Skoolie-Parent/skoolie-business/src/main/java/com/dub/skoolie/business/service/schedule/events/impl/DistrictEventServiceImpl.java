/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.schedule.events.impl;

import com.dub.skoolie.business.service.schedule.events.DistrictEventService;
import com.dub.skoolie.data.dao.schedule.events.DistrictEventRepository;
import com.dub.skoolie.data.entities.schedule.events.DistrictEvent;
import com.dub.skoolie.structures.schedule.events.DistrictEventBean;
import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;
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
public class DistrictEventServiceImpl implements DistrictEventService {
    
    @Autowired
    Mapper mapper;
    
    @Autowired
    DistrictEventRepository repo;

    @Override
    public DistrictEventBean updateEntity(DistrictEventBean entity) {
        DistrictEvent de = new  DistrictEvent();
        mapper.map(entity, de);
        de = repo.save(de);
        mapper.map(de,entity);
        return entity;
    }

    @Override
    public void deleteEntity(DistrictEventBean entity) {
        this.deleteByID(entity.getId());
    }

    @Override
    public void deleteByID(Long id) {
        repo.delete(id);
    }

    @Override
    public DistrictEventBean getByID(Long id) {
        DistrictEventBean deb = new DistrictEventBean();
        mapper.map(repo.findOne(id), deb);
        return deb;
    }

    @Override
    public List<DistrictEventBean> getAll() {
        List<DistrictEventBean> newlist = new ArrayList<>();
        Iterable<DistrictEvent> list = repo.findAll();
        for(DistrictEvent de : list) {
            newlist.add(mapper.map(de, DistrictEventBean.class));
        }
        return newlist;
    }
    
}
