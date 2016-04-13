/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.schedule.templates;

import com.dub.skoolie.structures.schedule.templates.ClassTimeBlockTemplateBean;
import com.dub.skoolie.web.service.schedule.templates.UiClassTimeBlockTemplateService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin W
 */
@Controller
public class SystemClassTimeBlockTemplateController {
    
    @Autowired
    UiClassTimeBlockTemplateService uiClassTimeBlockTemplateService;
    
    @RequestMapping(value="/system/schedule/templates/classtimeblock", method=RequestMethod.GET)
    public ModelAndView index(Model model) {
        ClassTimeBlockTemplateBean classTimeBlockTemplateBean = new ClassTimeBlockTemplateBean();
        model.addAttribute("classTimeBlockTemplateBean", classTimeBlockTemplateBean);
        model.addAttribute("classTimeBlockTemplateBeans", uiClassTimeBlockTemplateService.getClassTimeBlockTemplates());
        return new ModelAndView("system/schedule/templates/classtimeblock");
    }
    
    @RequestMapping(value="/system/schedule/templates/classtimeblock", method=RequestMethod.POST)
    public ModelAndView addClassTimeBlockTemplate(@Valid ClassTimeBlockTemplateBean classTimeBlockTemplateBean, BindingResult result,Model model) {
        if(result.hasErrors()) {
            model.addAttribute("classTimeBlockTemplateBean", classTimeBlockTemplateBean);
            model.addAttribute("gradingPeriodTemplateBeans", uiClassTimeBlockTemplateService.getClassTimeBlockTemplates());
            return new ModelAndView("system/schedule/templates/classtimeblock");
        }
        uiClassTimeBlockTemplateService.addClassTimeBlockTemplate(classTimeBlockTemplateBean);
        return new ModelAndView("redirect:/system/schedule/templates/classtimeblock");
    }
    
}
