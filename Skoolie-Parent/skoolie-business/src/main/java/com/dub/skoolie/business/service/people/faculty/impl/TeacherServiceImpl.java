/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.people.faculty.impl;

import com.dub.skoolie.business.service.people.faculty.TeacherService;
import com.dub.skoolie.data.dao.people.faculty.TeacherRepository;
import com.dub.skoolie.data.entities.people.faculty.Teacher;
import com.dub.skoolie.structures.people.faculty.TeacherBean;
import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    
    @Autowired
    DozerBeanMapper mapper;
    
    @Autowired
    TeacherRepository repo;

    @Override
    public TeacherBean updateEntity(TeacherBean entity) {
        Teacher t = new  Teacher();
        mapper.map(entity, t);
        t = repo.save(t);
        mapper.map(t,entity);
        return entity;
    }

    @Override
    public void deleteEntity(TeacherBean entity) {
        this.deleteByID(entity.getUsername());
    }

    @Override
    public void deleteByID(String id) {
        repo.delete(id);
    }

    @Override
    public TeacherBean getByID(String id) {
        TeacherBean t = new TeacherBean();
        try {
            mapper.map(repo.findOne(id), t);
        } catch(MappingException e) {
            //need to log this
            return null;
        }
        return t;
    }

    @Override
    public List<TeacherBean> getAll() {
        List<TeacherBean> newlist = new ArrayList<>();
        Iterable<Teacher> list = repo.findAll();
        for(Teacher t : list) {
            newlist.add(mapper.map(t, TeacherBean.class));
        }
        return newlist;
    }
    
}
