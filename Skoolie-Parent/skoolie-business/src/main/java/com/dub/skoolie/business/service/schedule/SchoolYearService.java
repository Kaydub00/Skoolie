/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.schedule;

import com.dub.skoolie.business.service.BaseCrudService;
import com.dub.skoolie.structures.schedule.SchoolYearBean;
import com.dub.skoolie.structures.school.SchoolBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface SchoolYearService extends BaseCrudService<SchoolYearBean,Long>{
    
    public List<SchoolYearBean> getSchoolYearBySchoolId(Long id);
    
    public List<SchoolYearBean> getSchoolYearBySchool(SchoolBean school);
    
}
