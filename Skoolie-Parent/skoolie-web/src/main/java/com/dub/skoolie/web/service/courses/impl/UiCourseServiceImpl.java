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
    public List<CourseBean> getCourse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CourseBean getCourse(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCourse(CourseBean subject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCourse(CourseBean subject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCourseById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCourse(CourseBean subject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
