/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.schedule.templates.impl;

import com.dub.skoolie.business.service.schedule.templates.ClassTimeBlockTemplateService;
import com.dub.skoolie.structures.schedule.templates.ClassTimeBlockTemplateBean;
import com.dub.skoolie.web.service.schedule.templates.UiClassTimeBlockTemplateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiClassTimeBlockTemplateServiceImpl implements UiClassTimeBlockTemplateService {
    
    @Autowired
    ClassTimeBlockTemplateService classTimeBlockTemplateService;

    @Override
    public List<ClassTimeBlockTemplateBean> getClassTimeBlockTemplates() {
        return classTimeBlockTemplateService.getAll();
    }

    @Override
    public void updateClassTimeBlockTemplate(ClassTimeBlockTemplateBean ctb) {
        classTimeBlockTemplateService.updateEntity(ctb);
    }

    @Override
    public void addClassTimeBlockTemplate(ClassTimeBlockTemplateBean ctb) {
        classTimeBlockTemplateService.updateEntity(ctb);
    }

    @Override
    public ClassTimeBlockTemplateBean getClassTimeBlockTemplate(Long id) {
        return classTimeBlockTemplateService.getByID(id);
    }
    
}
