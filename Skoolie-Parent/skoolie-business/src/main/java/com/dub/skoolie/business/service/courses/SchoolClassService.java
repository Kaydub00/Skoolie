/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.courses;

import com.dub.skoolie.business.service.BaseCrudService;
import com.dub.skoolie.structures.courses.SchoolClassBean;
import com.dub.skoolie.structures.people.faculty.TeacherBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface SchoolClassService extends BaseCrudService<SchoolClassBean,Long>{
    
    public List<SchoolClassBean> getTeacherSchoolClasses(String teacherName);
    
    public List<SchoolClassBean> getTeacherSchoolClasses(TeacherBean teacher);
    
    public List<SchoolClassBean> getTeacherCurrentSchoolClasses(String teacherName);
    
    public List<SchoolClassBean> getTeacherCurrentSchoolClasses(TeacherBean teacher);
    
}
