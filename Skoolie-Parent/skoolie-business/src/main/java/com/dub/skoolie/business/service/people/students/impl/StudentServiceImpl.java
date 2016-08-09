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
import com.dub.skoolie.structures.school.SchoolBean;
import java.util.ArrayList;
import java.util.List;
import org.dozer.Mapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kevin W
 */
@Transactional("skooliecoreTransactionManager")
@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    Mapper mapper;
    
    @Autowired
    StudentRepository repo;

    @Override
    public StudentBean updateEntity(StudentBean entity) {
        if(null == repo.findOne(entity.getUsername())) {
            //create user's privileges
        }
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

    @Override
    public List<StudentBean> getStudentsBySchool(SchoolBean school) {
        List<StudentBean> newlist = new ArrayList<>();
        Iterable<Student> list = repo.findStudentsBySchoolId(school.getId());
        for(Student s : list) {
            newlist.add(mapper.map(s, StudentBean.class));
        }
        return newlist;
    }

    @Override
    public List<StudentBean> getStudentsBySchool(Long id) {
        List<StudentBean> newlist = new ArrayList<>();
        Iterable<Student> list = repo.findStudentsBySchoolId(id);
        for(Student s : list) {
            newlist.add(mapper.map(s, StudentBean.class));
        }
        return newlist;
    }
    
}
