/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.schedule.templates;

import com.dub.skoolie.structures.schedule.templates.GradingPeriodTemplateBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiGradingPeriodTemplateService {
    
    public List<GradingPeriodTemplateBean> getGradingPeriodTemplates();
    
    public void updateGradingPeriodTemplate(GradingPeriodTemplateBean gptb);
    
    public void addGradingPeriodTemplate(GradingPeriodTemplateBean gptb);
    
    public GradingPeriodTemplateBean getGradingPeriodTemplate(Long id);
}
