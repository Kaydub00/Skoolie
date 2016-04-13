/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.schedule.templates;

import com.dub.skoolie.structures.schedule.templates.ClassTimeBlockTemplateBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiClassTimeBlockTemplateService {
    
    public List<ClassTimeBlockTemplateBean> getClassTimeBlockTemplates();
    
    public void updateClassTimeBlockTemplate(ClassTimeBlockTemplateBean ctb);
    
    public void addClassTimeBlockTemplate(ClassTimeBlockTemplateBean ctb);
    
    public ClassTimeBlockTemplateBean getClassTimeBlockTemplate(Long id);
    
}
