/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.schedule.impl;

import com.dub.skoolie.business.service.schedule.SchoolYearService;
import com.dub.skoolie.data.dao.schedule.SchoolYearRepository;
import com.dub.skoolie.data.entities.schedule.SchoolYear;
import com.dub.skoolie.structures.schedule.SchoolYearBean;
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
public class SchoolYearServiceImpl implements SchoolYearService {
    
    @Autowired
    Mapper mapper;
    
    @Autowired
    SchoolYearRepository repo;

    @Override
    public SchoolYearBean updateEntity(SchoolYearBean entity) {
        SchoolYear yr = new  SchoolYear();
        mapper.map(entity, yr);
        yr = repo.save(yr);
        mapper.map(yr,entity);
        return entity;
    }

    @Override
    public void deleteEntity(SchoolYearBean entity) {
        this.deleteByID(entity.getId());
    }

    @Override
    public void deleteByID(Long id) {
        repo.delete(id);
    }

    @Override
    public SchoolYearBean getByID(Long id) {
        SchoolYearBean yr = new SchoolYearBean();
        mapper.map(repo.findOne(id), yr);
        return yr;
    }

    @Override
    public List<SchoolYearBean> getAll() {
        List<SchoolYearBean> newlist = new ArrayList<>();
        Iterable<SchoolYear> list = repo.findAll();
        for(SchoolYear yr : list) {
            newlist.add(mapper.map(yr, SchoolYearBean.class));
        }
        return newlist;
    }
}
