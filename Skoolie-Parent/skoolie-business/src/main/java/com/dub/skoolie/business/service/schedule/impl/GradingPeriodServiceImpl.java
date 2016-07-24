/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.schedule.impl;

import com.dub.skoolie.business.service.schedule.GradingPeriodService;
import com.dub.skoolie.data.dao.schedule.GradingPeriodRepository;
import com.dub.skoolie.data.entities.schedule.GradingPeriod;
import com.dub.skoolie.structures.schedule.GradingPeriodBean;
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
public class GradingPeriodServiceImpl implements GradingPeriodService {
    
    @Autowired
    Mapper mapper;
    
    @Autowired
    GradingPeriodRepository repo;

    @Override
    public GradingPeriodBean updateEntity(GradingPeriodBean entity) {
        GradingPeriod gp = new  GradingPeriod();
        mapper.map(entity, gp);
        gp = repo.save(gp);
        mapper.map(gp,entity);
        return entity;
    }

    @Override
    public void deleteEntity(GradingPeriodBean entity) {
        this.deleteByID(entity.getId());
    }

    @Override
    public void deleteByID(Long id) {
        repo.delete(id);
    }

    @Override
    public GradingPeriodBean getByID(Long id) {
        GradingPeriodBean gp = new GradingPeriodBean();
        mapper.map(repo.findOne(id), gp);
        return gp;
    }

    @Override
    public List<GradingPeriodBean> getAll() {
        List<GradingPeriodBean> newlist = new ArrayList<>();
        Iterable<GradingPeriod> list = repo.findAll();
        for(GradingPeriod gp : list) {
            newlist.add(mapper.map(gp, GradingPeriodBean.class));
        }
        return newlist;
    }

    @Override
    public List<GradingPeriodBean> getGradingPeriodBySchoolId(Long id) {
        List<GradingPeriodBean> newlist = new ArrayList<>();
        Iterable<GradingPeriod> list = repo.findGradingPeriodBySchoolId(id);
        for(GradingPeriod gp : list) {
            newlist.add(mapper.map(gp, GradingPeriodBean.class));
        }
        return newlist;
    }
    
}
