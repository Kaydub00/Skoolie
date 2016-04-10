/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.school;

import com.dub.skoolie.structures.school.SchoolBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiSchoolService {
    
    public List<SchoolBean> getSchools();
    
    public void updateSchool(SchoolBean skl);
    
    public void addSchool(SchoolBean skl);
    
    public SchoolBean getSchool(Long id);
    
}
