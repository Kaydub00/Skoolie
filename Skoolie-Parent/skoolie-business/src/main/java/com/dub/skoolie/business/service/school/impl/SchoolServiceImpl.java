/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.school.impl;

import com.dub.skoolie.business.service.school.GradeLevelService;
import com.dub.skoolie.business.service.school.SchoolService;
import com.dub.skoolie.data.dao.school.SchoolRepository;
import com.dub.skoolie.data.entities.school.School;
import com.dub.skoolie.structures.school.GradeLevelBean;
import com.dub.skoolie.structures.school.SchoolBean;
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
public class SchoolServiceImpl implements SchoolService {
    
    @Autowired
    Mapper mapper;
    
    @Autowired
    SchoolRepository repo;
    
    @Autowired
    GradeLevelService gradeLevelServiceImpl;

    @Override
    public SchoolBean updateEntity(SchoolBean entity) {
        School skl = new  School();
        mapper.map(entity, skl);
        skl = repo.save(skl);
        mapper.map(skl,entity);
        return entity;
    }

    @Override
    public void deleteEntity(SchoolBean entity) {
        this.deleteByID(entity.getId());
    }

    @Override
    public void deleteByID(Long id) {
        repo.delete(id);
    }

    @Override
    public SchoolBean getByID(Long id) {
        SchoolBean skl = new SchoolBean();
        mapper.map(repo.findOne(id), skl);
        return skl;
    }

    @Override
    public List<SchoolBean> getAll() {
        List<SchoolBean> newlist = new ArrayList<>();
        Iterable<School> list = repo.findAll();
        for(School skl : list) {
            newlist.add(mapper.map(skl, SchoolBean.class));
        }
        return newlist;
    }

    @Override
    public List<GradeLevelBean> getAvailableGradeLevels() {
        return gradeLevelServiceImpl.getAll();
    }
    
}
