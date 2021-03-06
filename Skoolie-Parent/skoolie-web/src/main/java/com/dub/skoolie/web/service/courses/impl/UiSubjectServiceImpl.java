/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.courses.impl;

import com.dub.skoolie.business.service.courses.SubjectService;
import com.dub.skoolie.structures.courses.SubjectBean;
import com.dub.skoolie.structures.school.SchoolBean;
import com.dub.skoolie.web.service.courses.UiSubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiSubjectServiceImpl implements UiSubjectService {
    
    @Autowired
    SubjectService subjectServiceImpl;

    @Override
    public List<SubjectBean> getSubjects() {
        return subjectServiceImpl.getAll();
    }

    @Override
    public SubjectBean getSubject(Long id) {
        return subjectServiceImpl.getByID(id);
    }

    @Override
    public void updateSubject(SubjectBean subject) {
        subjectServiceImpl.updateEntity(subject);
    }

    @Override
    public void addSubject(SubjectBean subject) {
        subjectServiceImpl.updateEntity(subject);
    }

    @Override
    public void deleteSubjectById(Long id) {
        subjectServiceImpl.deleteByID(id);
    }

    @Override
    public void deleteSubject(SubjectBean subject) {
        subjectServiceImpl.deleteEntity(subject);
    }

    @Override
    public List<SubjectBean> getSubjectsBySchool(Long id) {
        return subjectServiceImpl.getSubjectsBySchoolId(id);
    }

    @Override
    public List<SubjectBean> getSubjectsBySchool(SchoolBean school) {
        return subjectServiceImpl.getSubjectsBySchool(school);
    }
    
}
