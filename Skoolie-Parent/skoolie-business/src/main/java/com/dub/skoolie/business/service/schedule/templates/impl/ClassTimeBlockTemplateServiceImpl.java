/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.schedule.templates.impl;

import com.dub.skoolie.business.service.schedule.templates.ClassTimeBlockTemplateService;
import com.dub.skoolie.data.dao.schedule.templates.ClassTimeBlockTemplateRepository;
import com.dub.skoolie.data.entities.schedule.templates.ClassTimeBlockTemplate;
import com.dub.skoolie.structures.schedule.templates.ClassTimeBlockTemplateBean;
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
public class ClassTimeBlockTemplateServiceImpl implements ClassTimeBlockTemplateService {
    
    @Autowired
    DozerBeanMapper mapper;
    
    @Autowired
    ClassTimeBlockTemplateRepository repo;
    
    
    @Override
    public ClassTimeBlockTemplateBean updateEntity(ClassTimeBlockTemplateBean entity) {
        ClassTimeBlockTemplate ctb = new  ClassTimeBlockTemplate();
        mapper.map(entity, ctb);
        ctb = repo.save(ctb);
        mapper.map(ctb,entity);
        return entity;
    }

    @Override
    public void deleteEntity(ClassTimeBlockTemplateBean entity) {
        this.deleteByID(entity.getId());
    }

    @Override
    public void deleteByID(Long id) {
        repo.delete(id);
    }

    @Override
    public ClassTimeBlockTemplateBean getByID(Long id) {
        ClassTimeBlockTemplateBean ctb = new ClassTimeBlockTemplateBean();
        mapper.map(repo.findOne(id), ctb);
        return ctb;
    }

    @Override
    public List<ClassTimeBlockTemplateBean> getAll() {
        List<ClassTimeBlockTemplateBean> newlist = new ArrayList<>();
        Iterable<ClassTimeBlockTemplate> list = repo.findAll();
        for(ClassTimeBlockTemplate ctb : list) {
            newlist.add(mapper.map(ctb, ClassTimeBlockTemplateBean.class));
        }
        return newlist;
    }
}
