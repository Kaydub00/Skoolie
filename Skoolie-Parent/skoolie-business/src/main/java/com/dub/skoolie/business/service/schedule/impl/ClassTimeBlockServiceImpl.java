/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.schedule.impl;

import com.dub.skoolie.business.service.schedule.ClassTimeBlockService;
import com.dub.skoolie.data.dao.schedule.ClassTimeBlockRepository;
import com.dub.skoolie.data.entities.schedule.ClassTimeBlock;
import com.dub.skoolie.structures.schedule.ClassTimeBlockBean;
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
public class ClassTimeBlockServiceImpl implements ClassTimeBlockService {
    
    @Autowired
    Mapper mapper;
    
    @Autowired
    ClassTimeBlockRepository repo;
    
    @Override
    public ClassTimeBlockBean updateEntity(ClassTimeBlockBean entity) {
        ClassTimeBlock ctb = new  ClassTimeBlock();
        mapper.map(entity, ctb);
        ctb = repo.save(ctb);
        mapper.map(ctb,entity);
        return entity;
        
    }

    @Override
    public void deleteEntity(ClassTimeBlockBean entity) {
        this.deleteByID(entity.getId());
    }

    @Override
    public void deleteByID(Long id) {
        repo.delete(id);
    }

    @Override
    public ClassTimeBlockBean getByID(Long id) {
        ClassTimeBlockBean ctb = new ClassTimeBlockBean();
        mapper.map(repo.findOne(id), ctb);
        return ctb;
    }

    @Override
    public List<ClassTimeBlockBean> getAll() {
        List<ClassTimeBlockBean> newlist = new ArrayList<>();
        Iterable<ClassTimeBlock> list = repo.findAll();
        for(ClassTimeBlock ctb : list) {
            newlist.add(mapper.map(ctb, ClassTimeBlockBean.class));
        }
        return newlist;
    }

    @Override
    public List<ClassTimeBlockBean> getClassTimeBlocksByGradingPeriod(GradingPeriodBean gradingPeriodBean) {
        List<ClassTimeBlockBean> newlist = new ArrayList<>();
        Iterable<ClassTimeBlock> list = repo.findClassTimeBlocksByGradingPeriodId(gradingPeriodBean.getId());
        for(ClassTimeBlock ctb : list) {
            newlist.add(mapper.map(ctb, ClassTimeBlockBean.class));
        }
        return newlist;
    }

    @Override
    public List<ClassTimeBlockBean> getClassTimeBlocksByGradingPeriod(Long id) {
        List<ClassTimeBlockBean> newlist = new ArrayList<>();
        Iterable<ClassTimeBlock> list = repo.findClassTimeBlocksByGradingPeriodId(id);
        for(ClassTimeBlock ctb : list) {
            newlist.add(mapper.map(ctb, ClassTimeBlockBean.class));
        }
        return newlist;
    }
}
