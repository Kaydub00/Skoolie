/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.schedule.templates.impl;

import com.dub.skoolie.business.service.schedule.templates.SchoolYearTemplateService;
import com.dub.skoolie.data.dao.schedule.templates.SchoolYearTemplateRepository;
import com.dub.skoolie.data.entities.schedule.templates.SchoolYearTemplate;
import com.dub.skoolie.structures.schedule.templates.SchoolYearTemplateBean;
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
public class SchoolYearTemplateServiceImpl implements SchoolYearTemplateService {
    
    @Autowired
    Mapper mapper;
    
    @Autowired
    SchoolYearTemplateRepository repo;
    
    @Override
    public SchoolYearTemplateBean updateEntity(SchoolYearTemplateBean entity) {
        SchoolYearTemplate yr = new  SchoolYearTemplate();
        mapper.map(entity, yr);
        yr = repo.save(yr);
        mapper.map(yr,entity);
        return entity;
    }

    @Override
    public void deleteEntity(SchoolYearTemplateBean entity) {
        this.deleteByID(entity.getId());
    }

    @Override
    public void deleteByID(Long id) {
        repo.delete(id);
    }

    @Override
    public SchoolYearTemplateBean getByID(Long id) {
        SchoolYearTemplateBean yr = new SchoolYearTemplateBean();
        mapper.map(repo.findOne(id), yr);
        return yr;
    }

    @Override
    public List<SchoolYearTemplateBean> getAll() {
        List<SchoolYearTemplateBean> newlist = new ArrayList<>();
        Iterable<SchoolYearTemplate> list = repo.findAll();
        for(SchoolYearTemplate yr : list) {
            newlist.add(mapper.map(yr, SchoolYearTemplateBean.class));
        }
        return newlist;
    }
    
}
