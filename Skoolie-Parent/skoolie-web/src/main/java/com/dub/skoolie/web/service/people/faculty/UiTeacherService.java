/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.people.faculty;

import com.dub.skoolie.structures.people.faculty.TeacherBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiTeacherService {
    
    public List<TeacherBean> getTeachers();
    
    public TeacherBean getTeacher(String username);
    
    public void updateTeacher(TeacherBean user);
    
    public void addTeacher(TeacherBean user);
    
    public void deleteTeacherByUsername(String username);
    
    public void deleteTeacher(TeacherBean user);
    
}
