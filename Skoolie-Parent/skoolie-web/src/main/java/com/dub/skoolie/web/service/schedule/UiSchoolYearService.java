/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.schedule;

import com.dub.skoolie.structures.schedule.SchoolYearBean;
import com.dub.skoolie.structures.school.SchoolBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiSchoolYearService {
    
    public List<SchoolYearBean> getSchoolYears();
    
    public void updateSchoolYear(SchoolYearBean skl);
    
    public void addSchoolYear(SchoolYearBean skl);
    
    public SchoolYearBean getSchoolYear(Long id);
    
    public List<SchoolBean> getAllSchools();
    
    public void deleteSchoolYear(Long id);
    
    public List<SchoolYearBean> getSchoolYearsBySchoolId(Long id);
    
    public List<SchoolYearBean> getSchoolYearsBySchool(SchoolBean school);
    
}
