/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.courses.impl;

import com.dub.skoolie.business.service.courses.CourseService;
import com.dub.skoolie.data.dao.courses.CourseRepository;
import com.dub.skoolie.data.entities.courses.Course;
import com.dub.skoolie.structures.courses.CourseBean;
import com.dub.skoolie.structures.courses.SubjectBean;
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
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    Mapper mapper;
    
    @Autowired
    CourseRepository repo;

    @Override
    public List<CourseBean> getCoursesBySchool(SchoolBean school) {
        List<CourseBean> newlist = new ArrayList<>();
        Iterable<Course> list = repo.findCourseBySchoolId(school.getId());
        for(Course crs : list) {
            newlist.add(mapper.map(crs, CourseBean.class));
        }
        return newlist;
    }

    @Override
    public List<CourseBean> getCoursesBySchoolId(Long id) {
        List<CourseBean> newlist = new ArrayList<>();
        Iterable<Course> list = repo.findCourseBySchoolId(id);
        for(Course crs : list) {
            newlist.add(mapper.map(crs, CourseBean.class));
        }
        return newlist;
    }

    @Override
    public List<CourseBean> getCoursesBySubject(SubjectBean subject) {
        List<CourseBean> newlist = new ArrayList<>();
        Iterable<Course> list = repo.findCourseBySubjectId(subject.getId());
        for(Course crs : list) {
            newlist.add(mapper.map(crs, CourseBean.class));
        }
        return newlist;
    }

    @Override
    public List<CourseBean> getCoursesBySubjectId(Long id) {
        List<CourseBean> newlist = new ArrayList<>();
        Iterable<Course> list = repo.findCourseBySubjectId(id);
        for(Course crs : list) {
            newlist.add(mapper.map(crs, CourseBean.class));
        }
        return newlist;
    }

    @Override
    public CourseBean updateEntity(CourseBean entity) {
        Course crs = new Course();
        mapper.map(entity, crs);
        crs = repo.save(crs);
        mapper.map(crs,entity);
        return entity;
    }

    @Override
    public void deleteEntity(CourseBean entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteByID(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CourseBean getByID(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CourseBean> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
