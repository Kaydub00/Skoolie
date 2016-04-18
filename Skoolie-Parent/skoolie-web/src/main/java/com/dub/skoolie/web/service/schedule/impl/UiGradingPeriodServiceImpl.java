/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.schedule.impl;

import com.dub.skoolie.business.service.schedule.GradingPeriodService;
import com.dub.skoolie.business.service.schedule.SchoolYearService;
import com.dub.skoolie.structures.schedule.GradingPeriodBean;
import com.dub.skoolie.structures.schedule.SchoolYearBean;
import com.dub.skoolie.web.service.schedule.UiGradingPeriodService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiGradingPeriodServiceImpl implements UiGradingPeriodService{
    
    @Autowired
    GradingPeriodService gradingPeriodServiceImpl;
    
    @Autowired
    SchoolYearService schoolYearServiceImpl;

    @Override
    public List<GradingPeriodBean> getGradingPeriods() {
        return gradingPeriodServiceImpl.getAll();
    }

    @Override
    public void updateGradingPeriod(GradingPeriodBean gpb) {
        gradingPeriodServiceImpl.updateEntity(gpb);
    }

    @Override
    public void addGradingPeriod(GradingPeriodBean gpb) {
        gradingPeriodServiceImpl.updateEntity(gpb);
    }

    @Override
    public GradingPeriodBean getGradingPeriod(Long id) {
        return gradingPeriodServiceImpl.getByID(id);
    }

    @Override
    public List<SchoolYearBean> getSchoolYears() {
        return schoolYearServiceImpl.getAll();
    }

    @Override
    public void deleteGradingPeriod(Long id) {
        gradingPeriodServiceImpl.deleteByID(id);
    }
    
}
