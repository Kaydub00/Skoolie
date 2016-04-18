/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.schedule;

import com.dub.skoolie.structures.schedule.SchoolYearBean;
import com.dub.skoolie.web.service.schedule.UiSchoolYearService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin W
 */
@Controller
public class SystemSchoolYearController {
    
    @Autowired
    UiSchoolYearService uiSchoolYearServiceImpl;
    
    @RequestMapping(value="/system/schedule/schoolyear", method=RequestMethod.GET)
    public ModelAndView getSchoolYears(Model model) {
        model.addAttribute("schoolYearBeans", uiSchoolYearServiceImpl.getSchoolYears());
        model.addAttribute("schoolYearBean", new SchoolYearBean());
        model.addAttribute("allSchools", uiSchoolYearServiceImpl.getAllSchools());
        return new ModelAndView("system/schedule/schoolyear");
    }
    
    @RequestMapping(value="/system/schedule/schoolyear", method=RequestMethod.POST)
    public ModelAndView addSchoolYear(@Valid SchoolYearBean schoolYearBean, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("schoolYearBeans", uiSchoolYearServiceImpl.getSchoolYears());
            model.addAttribute("schoolYearBean", schoolYearBean);
            model.addAttribute("allSchools", uiSchoolYearServiceImpl.getAllSchools());
            return new ModelAndView("system/schedule/schoolyear");
        }
        uiSchoolYearServiceImpl.addSchoolYear(schoolYearBean);
        return new ModelAndView("redirect:/system/schedule/schoolyear");
    }
    
    @RequestMapping(value="/system/schedule/schoolyear/delete", method=RequestMethod.POST)
    public ModelAndView deleteSchoolYear(@RequestParam("schoolyear") String id, Model model) {
        uiSchoolYearServiceImpl.deleteSchoolYear(Long.parseLong(id));
        return new ModelAndView("redirect:/system/schedule/schoolyear");
    }
    
}
