/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.schedule.templates;

import com.dub.skoolie.structures.schedule.templates.SchoolYearTemplateBean;
import com.dub.skoolie.web.service.schedule.templates.UiSchoolYearTemplateService;
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
public class SystemSchoolYearTemplateController {
    
    @Autowired
    UiSchoolYearTemplateService uiSchoolYearTemplateServiceImpl;
    
    @RequestMapping(value="/system/schedule/templates/schoolyear", method=RequestMethod.GET)
    public ModelAndView index(Model model) {
        SchoolYearTemplateBean schoolYearTemplateBean = new SchoolYearTemplateBean();
        model.addAttribute("schoolYearTemplateBean", schoolYearTemplateBean);
        model.addAttribute("schoolYearTemplateBeans", uiSchoolYearTemplateServiceImpl.getSchoolYearTemplates());
        return new ModelAndView("system/schedule/templates/schoolyear");
    }
    
    @RequestMapping(value="/system/schedule/templates/schoolyear", method=RequestMethod.POST)
    public ModelAndView addYearTemplate(@Valid SchoolYearTemplateBean schoolYearTemplateBean, BindingResult result,Model model) {
        if(result.hasErrors()) {
            model.addAttribute("schoolYearTemplateBean", schoolYearTemplateBean);
            model.addAttribute("schoolYearTemplateBeans", uiSchoolYearTemplateServiceImpl.getSchoolYearTemplates());
            return new ModelAndView("system/schedule/templates/schoolyear");
        }
        uiSchoolYearTemplateServiceImpl.addSchoolYearTemplate(schoolYearTemplateBean);
        return new ModelAndView("redirect:/system/schedule/templates/schoolyear");
    }
    
}
