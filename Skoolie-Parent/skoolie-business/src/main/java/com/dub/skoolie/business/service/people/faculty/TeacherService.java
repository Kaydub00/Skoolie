/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.people.faculty;

import com.dub.skoolie.business.service.BaseCrudService;
import com.dub.skoolie.structures.people.faculty.TeacherBean;
import com.dub.skoolie.structures.school.SchoolBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface TeacherService extends BaseCrudService<TeacherBean,String> {
    
    public List<TeacherBean> getTeachersBySchool(SchoolBean school);
    
    public List<TeacherBean> getTeachersBySchool(Long id);
    
}
