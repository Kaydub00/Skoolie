/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.people.students;

import com.dub.skoolie.structures.people.students.StudentBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiStudentService {
    
    public List<StudentBean> getStudents();
    
    public StudentBean getStudent(String username);
    
    public void updateStudent(StudentBean user);
    
    public void addStudent(StudentBean user);
    
    public void deleteStudentByUsername(String username);
    
    public void deleteStudent(StudentBean user);
    
}
