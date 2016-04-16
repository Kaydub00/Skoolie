/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.school;

import com.dub.skoolie.structures.school.SchoolBean;
import com.dub.skoolie.web.service.school.UiSchoolService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin W
 */
@Controller
public class SystemSchoolController {
    
    @Autowired
    UiSchoolService uiSchoolServiceImpl;
    
    @RequestMapping(value="/system/schools", method=RequestMethod.GET)
    public ModelAndView getSchools(Model model) {
        model.addAttribute("schools", uiSchoolServiceImpl.getSchools());
        model.addAttribute("schoolBean", new SchoolBean());
        return new ModelAndView("system/school/schools");
    }
    
    @RequestMapping(value="/system/schools", method=RequestMethod.POST)
    public ModelAndView addSchool(@Valid SchoolBean schoolBean, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("schoolBean", schoolBean);
            model.addAttribute("schools", uiSchoolServiceImpl.getSchools());
            return new ModelAndView("system/school/schools");
        }
        uiSchoolServiceImpl.addSchool(schoolBean);
        return new ModelAndView("redirect:/system/schools");
    }
    
    @RequestMapping(value="/system/schools/{id}", method=RequestMethod.GET)
    public ModelAndView getSchool(@PathVariable("id") Long school, Model model) {
        SchoolBean skl = uiSchoolServiceImpl.getSchool(school);
        model.addAttribute("school", skl);
        return new ModelAndView("system/school/school");
    }
    
}
