/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.courses.impl;

import com.dub.skoolie.business.service.courses.SchoolClassService;
import com.dub.skoolie.data.dao.courses.SchoolClassRepository;
import com.dub.skoolie.data.entities.courses.SchoolClass;
import com.dub.skoolie.structures.courses.SchoolClassBean;
import java.util.ArrayList;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class SchoolClassServiceImpl implements SchoolClassService {
    
    @Autowired
    Mapper mapper;
    
    @Autowired
    SchoolClassRepository repo;

    @Override
    public SchoolClassBean updateEntity(SchoolClassBean entity) {
        SchoolClass skcls = new SchoolClass();
        mapper.map(entity, skcls);
        skcls = repo.save(skcls);
        mapper.map(skcls,entity);
        return entity;
    }

    @Override
    public void deleteEntity(SchoolClassBean entity) {
        repo.delete(entity.getId());
    }

    @Override
    public void deleteByID(Long id) {
        repo.delete(id);
    }

    @Override
    public SchoolClassBean getByID(Long id) {
        SchoolClassBean skcls = new SchoolClassBean();
        mapper.map(repo.findOne(id), skcls);
        return skcls;
    }

    @Override
    public List<SchoolClassBean> getAll() {
        List<SchoolClassBean> newlist = new ArrayList<>();
        Iterable<SchoolClass> list = repo.findAll();
        for(SchoolClass skcls : list) {
            newlist.add(mapper.map(skcls, SchoolClassBean.class));
        }
        return newlist;
    }
    
}
