/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.schedule;

import com.dub.skoolie.business.service.BaseCrudService;
import com.dub.skoolie.structures.schedule.GradingPeriodBean;
import com.dub.skoolie.structures.school.SchoolBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface GradingPeriodService extends BaseCrudService<GradingPeriodBean,Long>{
    
    public List<GradingPeriodBean> getGradingPeriodBySchoolId(Long id);
    
    public GradingPeriodBean getCurrentGradingPeriodBySchoolId(Long id);
    
    public GradingPeriodBean getCurrentGradingPeriodBySchool(SchoolBean school);
    
}
