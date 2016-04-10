/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.schedule.templates;


import com.dub.skoolie.structures.schedule.templates.SchoolYearTemplateBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiSchoolYearTemplateService {
    
    public List<SchoolYearTemplateBean> getSchoolYearTemplates();
    
    public void updateSchoolYearTemplate(SchoolYearTemplateBean skl);
    
    public void addSchoolYearTemplate(SchoolYearTemplateBean skl);
    
    public SchoolYearTemplateBean getSchoolYearTemplate(Long id);
    
}
