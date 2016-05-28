/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.people.students.impl;

import com.dub.skoolie.business.service.people.students.StudentService;
import com.dub.skoolie.data.dao.people.students.StudentRepository;
import com.dub.skoolie.data.entities.people.students.Student;
import com.dub.skoolie.structures.people.students.StudentBean;
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
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    DozerBeanMapper mapper;
    
    @Autowired
    StudentRepository repo;

    @Override
    public StudentBean updateEntity(StudentBean entity) {
        Student s = new  Student();
        mapper.map(entity, s);
        s = repo.save(s);
        mapper.map(s,entity);
        return entity;
    }

    @Override
    public void deleteEntity(StudentBean entity) {
        this.deleteByID(entity.getUsername());
    }

    @Override
    public void deleteByID(String id) {
        repo.delete(id);
    }

    @Override
    public StudentBean getByID(String id) {
        StudentBean s = new StudentBean();
        try {
            mapper.map(repo.findOne(id), s);
        } catch(MappingException e) {
            //need to log this
            return null;
        }
        return s;
    }

    @Override
    public List<StudentBean> getAll() {
        List<StudentBean> newlist = new ArrayList<>();
        Iterable<Student> list = repo.findAll();
        for(Student s : list) {
            newlist.add(mapper.map(s, StudentBean.class));
        }
        return newlist;
    }
    
}
