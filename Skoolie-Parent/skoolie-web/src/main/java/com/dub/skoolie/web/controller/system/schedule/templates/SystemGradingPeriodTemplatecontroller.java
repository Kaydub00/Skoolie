/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.schedule.templates;

import com.dub.skoolie.structures.schedule.templates.GradingPeriodTemplateBean;
import com.dub.skoolie.web.service.schedule.templates.UiGradingPeriodTemplateService;
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
public class SystemGradingPeriodTemplatecontroller {
    
    @Autowired
    UiGradingPeriodTemplateService uiGradingPeriodTemplateServiceImpl;
    
    @RequestMapping(value="/system/schedule/templates/gradingperiod", method=RequestMethod.GET)
    public ModelAndView index(Model model) {
        GradingPeriodTemplateBean gradingPeriodTemplateBean = new GradingPeriodTemplateBean();
        model.addAttribute("gradingPeriodTemplateBean", gradingPeriodTemplateBean);
        model.addAttribute("gradingPeriodTemplateBeans", uiGradingPeriodTemplateServiceImpl.getGradingPeriodTemplates());
        return new ModelAndView("system/schedule/templates/gradingperiod");
    }
    
    @RequestMapping(value="/system/schedule/templates/gradingperiod", method=RequestMethod.POST)
    public ModelAndView addGradingPeriodTemplate(@Valid GradingPeriodTemplateBean gradingPeriodTemplateBean, BindingResult result,Model model) {
        if(result.hasErrors()) {
            model.addAttribute("gradingPeriodTemplateBean", gradingPeriodTemplateBean);
            model.addAttribute("gradingPeriodTemplateBeans", uiGradingPeriodTemplateServiceImpl.getGradingPeriodTemplates());
            return new ModelAndView("system/schedule/templates/gradingperiod");
        }
        uiGradingPeriodTemplateServiceImpl.addGradingPeriodTemplate(gradingPeriodTemplateBean);
        return new ModelAndView("redirect:/system/schedule/templates/gradingperiod");
    }
    
}
