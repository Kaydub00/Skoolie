/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.courses;

import com.dub.skoolie.structures.courses.SchoolClassBean;
import com.dub.skoolie.structures.people.faculty.TeacherBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiSchoolClassService {
    
    public List<SchoolClassBean> getSchoolClasses();
    
    public SchoolClassBean getSchoolClass(Long id);
    
    public List<SchoolClassBean> getTeacherCurrentClasses(TeacherBean teacher);
    
    public List<SchoolClassBean> getTeacherCurrentClasses(String teacherName);
    
    public List<SchoolClassBean> getTeacherClasses(TeacherBean teacher);
    
    public List<SchoolClassBean> getTeacherClasses(String teacherName);
    
    public void updateSchoolClass(SchoolClassBean schoolClassBean);
    
    public void addSchoolClass(SchoolClassBean schoolClassBean);
    
    public void deleteSchoolClassById(Long id);
    
    public void deleteSchoolClass(SchoolClassBean schoolClassBean);
    
}
