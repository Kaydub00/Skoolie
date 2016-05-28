/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.people.students.impl;

import com.dub.skoolie.business.service.people.students.StudentService;
import com.dub.skoolie.structures.people.students.StudentBean;
import com.dub.skoolie.web.service.people.students.UiStudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiStudentServiceImpl implements UiStudentService {
    
    @Autowired
    StudentService studentServiceImpl;

    @Override
    public List<StudentBean> getStudents() {
        return studentServiceImpl.getAll();
    }

    @Override
    public StudentBean getStudent(String username) {
        return studentServiceImpl.getByID(username);
    }

    @Override
    public void updateStudent(StudentBean user) {
        studentServiceImpl.updateEntity(user);
    }

    @Override
    public void addStudent(StudentBean user) {
        studentServiceImpl.updateEntity(user);
    }

    @Override
    public void deleteStudentByUsername(String username) {
        studentServiceImpl.deleteByID(username);
    }

    @Override
    public void deleteStudent(StudentBean user) {
        studentServiceImpl.deleteEntity(user);
    }
    
}
