/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.people.students;

import com.dub.skoolie.business.service.BaseCrudService;
import com.dub.skoolie.structures.people.students.StudentBean;
import com.dub.skoolie.structures.school.SchoolBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface StudentService extends BaseCrudService<StudentBean,String> {
    
    public List<StudentBean> getStudentsBySchool(SchoolBean school);
    
    public List<StudentBean> getStudentsBySchool(Long id);
    
}
