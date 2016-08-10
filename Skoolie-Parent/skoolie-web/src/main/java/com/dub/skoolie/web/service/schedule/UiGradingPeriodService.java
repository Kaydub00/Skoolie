/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.schedule;

import com.dub.skoolie.structures.schedule.GradingPeriodBean;
import com.dub.skoolie.structures.schedule.SchoolYearBean;
import com.dub.skoolie.structures.school.SchoolBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiGradingPeriodService {
    
    public List<GradingPeriodBean> getGradingPeriods();
    
    public void updateGradingPeriod(GradingPeriodBean gpb);
    
    public void addGradingPeriod(GradingPeriodBean gpb);
    
    public GradingPeriodBean getGradingPeriod(Long id);
    
    public List<SchoolYearBean> getSchoolYears();
    
    public void deleteGradingPeriod(Long id);
    
    public List<GradingPeriodBean> getGradingPeriodBySchoolId(Long id);
    
    public GradingPeriodBean getCurrentGradingPeriodBySchool(SchoolBean school);
    
    public GradingPeriodBean getCurrentGradingPeriodBySchool(Long id);
}
