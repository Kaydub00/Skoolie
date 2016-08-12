/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.courses.impl;

import com.dub.skoolie.business.service.courses.CourseService;
import com.dub.skoolie.structures.courses.CourseBean;
import com.dub.skoolie.structures.courses.SubjectBean;
import com.dub.skoolie.structures.school.SchoolBean;
import com.dub.skoolie.web.service.courses.UiCourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiCourseServiceImpl implements UiCourseService{
    
    @Autowired
    CourseService courseServiceImpl;

    @Override
    public List<CourseBean> getCourses() {
        return courseServiceImpl.getAll();
    }

    @Override
    public CourseBean getCourse(Long id) {
        return courseServiceImpl.getByID(id);
    }

    @Override
    public void updateCourse(CourseBean subject) {
        courseServiceImpl.updateEntity(subject);
    }

    @Override
    public void addCourse(CourseBean subject) {
        courseServiceImpl.updateEntity(subject);
    }

    @Override
    public void deleteCourseById(Long id) {
        courseServiceImpl.deleteByID(id);
    }

    @Override
    public void deleteCourse(CourseBean subject) {
        courseServiceImpl.deleteEntity(subject);
    }

    @Override
    public List<CourseBean> getCoursesBySchool(Long id) {
        return courseServiceImpl.getCoursesBySchoolId(id);
    }

    @Override
    public List<CourseBean> getCoursesBySchool(SchoolBean school) {
        return courseServiceImpl.getCoursesBySchool(school);
    }

    @Override
    public List<CourseBean> getCoursesBySubject(Long id) {
        return courseServiceImpl.getCoursesBySubjectId(id);
    }

    @Override
    public List<CourseBean> getCoursesBySubject(SubjectBean subject) {
        return courseServiceImpl.getCoursesBySubject(subject);
    }
    
}
