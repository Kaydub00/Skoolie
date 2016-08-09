/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.people.faculty.impl;

import com.dub.skoolie.business.service.people.faculty.TeacherService;
import com.dub.skoolie.structures.people.faculty.TeacherBean;
import com.dub.skoolie.structures.school.SchoolBean;
import com.dub.skoolie.web.service.people.faculty.UiTeacherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiTeacherServiceImpl implements UiTeacherService{
    
    @Autowired
    TeacherService teacherServiceImpl;

    @Override
    public List<TeacherBean> getTeachers() {
        return teacherServiceImpl.getAll();
    }

    @Override
    public TeacherBean getTeacher(String username) {
        return teacherServiceImpl.getByID(username);
    }

    @Override
    public void updateTeacher(TeacherBean user) {
        teacherServiceImpl.updateEntity(user);
    }

    @Override
    public void addTeacher(TeacherBean user) {
        teacherServiceImpl.updateEntity(user);
    }

    @Override
    public void deleteTeacherByUsername(String username) {
        teacherServiceImpl.deleteByID(username);
    }

    @Override
    public void deleteTeacher(TeacherBean user) {
        teacherServiceImpl.deleteEntity(user);
    }

    @Override
    public List<TeacherBean> getTeachersBySchool(SchoolBean school) {
        return teacherServiceImpl.getTeachersBySchool(school);
    }

    @Override
    public List<TeacherBean> getTeachersBySchool(Long id) {
        return teacherServiceImpl.getTeachersBySchool(id);
    }
    
}
