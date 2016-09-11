/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.courses.impl;

import com.dub.skoolie.business.service.courses.SchoolClassService;
import com.dub.skoolie.structures.courses.SchoolClassBean;
import com.dub.skoolie.structures.people.faculty.TeacherBean;
import com.dub.skoolie.web.service.courses.UiSchoolClassService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiSchoolClassServiceImpl implements UiSchoolClassService {
    
    @Autowired
    SchoolClassService schoolClassServiceImpl;

    @Override
    public List<SchoolClassBean> getSchoolClasses() {
        return schoolClassServiceImpl.getAll();
    }

    @Override
    public SchoolClassBean getSchoolClass(Long id) {
        return schoolClassServiceImpl.getByID(id);
    }

    @Override
    public void updateSchoolClass(SchoolClassBean schoolClassBean) {
        schoolClassServiceImpl.updateEntity(schoolClassBean);
    }

    @Override
    public void addSchoolClass(SchoolClassBean schoolClassBean) {
        schoolClassServiceImpl.updateEntity(schoolClassBean);
    }

    @Override
    public void deleteSchoolClassById(Long id) {
        schoolClassServiceImpl.deleteByID(id);
    }

    @Override
    public void deleteSchoolClass(SchoolClassBean schoolClassBean) {
        schoolClassServiceImpl.deleteEntity(schoolClassBean);
    }

    @Override
    public List<SchoolClassBean> getTeacherCurrentClasses(TeacherBean teacher) {
        return schoolClassServiceImpl.getTeacherCurrentSchoolClasses(teacher);
    }

    @Override
    public List<SchoolClassBean> getTeacherCurrentClasses(String teacherName) {
        return schoolClassServiceImpl.getTeacherCurrentSchoolClasses(teacherName);
    }

    @Override
    public List<SchoolClassBean> getTeacherClasses(TeacherBean teacher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SchoolClassBean> getTeacherClasses(String teacherName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
