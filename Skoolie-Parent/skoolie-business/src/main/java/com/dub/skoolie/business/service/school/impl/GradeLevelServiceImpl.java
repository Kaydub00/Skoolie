/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.school.impl;

import com.dub.skoolie.business.service.school.GradeLevelService;
import com.dub.skoolie.data.dao.school.GradeLevelRepository;
import com.dub.skoolie.data.entities.school.GradeLevel;
import com.dub.skoolie.structures.school.GradeLevelBean;
import java.util.ArrayList;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevinw
 */
@Service
public class GradeLevelServiceImpl implements GradeLevelService {
    
    @Autowired
    GradeLevelRepository repo;
    
    @Autowired
    Mapper mapper;

    @Override
    public GradeLevelBean updateEntity(GradeLevelBean entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEntity(GradeLevelBean entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteByID(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GradeLevelBean getByID(Long id) {
        GradeLevelBean glb = new GradeLevelBean();
        mapper.map(repo.findOne(id), glb);
        return glb;
    }

    @Override
    public List<GradeLevelBean> getAll() {
        List<GradeLevelBean> newlist = new ArrayList<>();
        Iterable<GradeLevel> list = repo.findAll();
        for(GradeLevel gl : list) {
            newlist.add(mapper.map(gl, GradeLevelBean.class));
        }
        return newlist;
    }
}
