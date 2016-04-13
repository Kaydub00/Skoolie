/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.schedule.templates.impl;

import com.dub.skoolie.business.service.schedule.templates.GradingPeriodTemplateService;
import com.dub.skoolie.structures.schedule.templates.GradingPeriodTemplateBean;
import com.dub.skoolie.web.service.schedule.templates.UiGradingPeriodTemplateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiGradingPeriodTemplateServiceImpl implements UiGradingPeriodTemplateService {
    
    @Autowired
    GradingPeriodTemplateService gradingPeriodTemplateServiceImpl;

    @Override
    public List<GradingPeriodTemplateBean> getGradingPeriodTemplates() {
        return gradingPeriodTemplateServiceImpl.getAll();
    }

    @Override
    public void updateGradingPeriodTemplate(GradingPeriodTemplateBean gptb) {
        gradingPeriodTemplateServiceImpl.updateEntity(gptb);
    }

    @Override
    public void addGradingPeriodTemplate(GradingPeriodTemplateBean gptb) {
        gradingPeriodTemplateServiceImpl.updateEntity(gptb);
    }

    @Override
    public GradingPeriodTemplateBean getGradingPeriodTemplate(Long id) {
        return gradingPeriodTemplateServiceImpl.getByID(id);
    }
    
}
