/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.courses;

import com.dub.skoolie.business.service.BaseCrudService;
import com.dub.skoolie.structures.courses.SubjectBean;
import com.dub.skoolie.structures.school.SchoolBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface SubjectService extends BaseCrudService<SubjectBean,Long>{
    
    public List<SubjectBean> getSubjectsBySchool(SchoolBean school);
    
    public List<SubjectBean> getSubjectsBySchoolId(Long id);
}
