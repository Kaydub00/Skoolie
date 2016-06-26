/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.schedule.templates.impl;

import com.dub.skoolie.business.service.schedule.templates.GradingPeriodTemplateService;
import com.dub.skoolie.data.dao.schedule.templates.GradingPeriodTemplateRepository;
import com.dub.skoolie.data.entities.schedule.templates.GradingPeriodTemplate;
import com.dub.skoolie.structures.schedule.templates.GradingPeriodTemplateBean;
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
public class GradingPeriodTemplateServiceImpl implements GradingPeriodTemplateService {
    
    @Autowired
    Mapper mapper;
    
    @Autowired
    GradingPeriodTemplateRepository repo;
    
    @Override
    public GradingPeriodTemplateBean updateEntity(GradingPeriodTemplateBean entity) {
        GradingPeriodTemplate gp = new  GradingPeriodTemplate();
        mapper.map(entity, gp);
        gp = repo.save(gp);
        mapper.map(gp,entity);
        return entity;
    }

    @Override
    public void deleteEntity(GradingPeriodTemplateBean entity) {
        this.deleteByID(entity.getId());
    }

    @Override
    public void deleteByID(Long id) {
        repo.delete(id);
    }

    @Override
    public GradingPeriodTemplateBean getByID(Long id) {
        GradingPeriodTemplateBean gp = new GradingPeriodTemplateBean();
        mapper.map(repo.findOne(id), gp);
        return gp;
    }

    @Override
    public List<GradingPeriodTemplateBean> getAll() {
        List<GradingPeriodTemplateBean> newlist = new ArrayList<>();
        Iterable<GradingPeriodTemplate> list = repo.findAll();
        for(GradingPeriodTemplate gp : list) {
            newlist.add(mapper.map(gp, GradingPeriodTemplateBean.class));
        }
        return newlist;
    }
}
