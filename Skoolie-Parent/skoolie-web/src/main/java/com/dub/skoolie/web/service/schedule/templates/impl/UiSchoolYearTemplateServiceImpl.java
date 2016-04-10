/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.schedule.templates.impl;

import com.dub.skoolie.business.service.schedule.templates.SchoolYearTemplateService;
import com.dub.skoolie.structures.schedule.SchoolYearBean;
import com.dub.skoolie.structures.schedule.templates.SchoolYearTemplateBean;
import com.dub.skoolie.web.service.schedule.templates.UiSchoolYearTemplateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiSchoolYearTemplateServiceImpl implements UiSchoolYearTemplateService {
    
    @Autowired
    SchoolYearTemplateService schoolYearTemplateServiceImpl;

    @Override
    public List<SchoolYearTemplateBean> getSchoolYearTemplates() {
        return schoolYearTemplateServiceImpl.getAll();
    }

    @Override
    public void updateSchoolYearTemplate(SchoolYearTemplateBean skl) {
        schoolYearTemplateServiceImpl.updateEntity(skl);
    }

    @Override
    public void addSchoolYearTemplate(SchoolYearTemplateBean skl) {
        schoolYearTemplateServiceImpl.updateEntity(skl);
    }

    @Override
    public SchoolYearTemplateBean getSchoolYearTemplate(Long id) {
        return schoolYearTemplateServiceImpl.getByID(id);
    }
    
}
