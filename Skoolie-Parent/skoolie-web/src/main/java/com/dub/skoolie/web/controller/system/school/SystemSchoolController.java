/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.school;

import com.dub.skoolie.structures.school.SchoolBean;
import com.dub.skoolie.web.service.district.UiDistrictService;
import com.dub.skoolie.web.service.school.UiSchoolService;
import javax.servlet.http.HttpServletRequest;
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
    
    @Autowired
    UiDistrictService uiDistrictServiceImpl;
    
    @RequestMapping(value="/system/schools", method=RequestMethod.GET)
    public ModelAndView getSchools(Model model) {
        model.addAttribute("districtBeans", uiDistrictServiceImpl.getDistricts());
        model.addAttribute("schools", uiSchoolServiceImpl.getSchools());
        model.addAttribute("schoolBean", new SchoolBean());
        return new ModelAndView("system/school/schools");
    }
    
    @RequestMapping(value="/system/schools", method=RequestMethod.POST)
    public ModelAndView addSchool(@Valid SchoolBean schoolBean, BindingResult result, Model model, HttpServletRequest request) {
        //If I add more model attributes I can probably cut back on a lot of the sql being ran. The way I use the object in the view
        //is causing a ton of sql to run and I see a lot of duplicate queries running. due to jpa
        //I'm not worried about this right now, but once I have more of the app completed I'll need to start working on optimizing this
        String referrer = request.getHeader("Referer");
        if(result.hasErrors()) {
            if(!referrer.equals("/system/schools")) {
                return new ModelAndView("redirect:" + referrer);
            }
            model.addAttribute("schoolBean", schoolBean);
            model.addAttribute("schools", uiSchoolServiceImpl.getSchools());
            return new ModelAndView("system/school/schools");
        }
        uiSchoolServiceImpl.addSchool(schoolBean);
        return new ModelAndView("redirect:" + referrer);
    }
    
    @RequestMapping(value="/system/schools/{id}", method=RequestMethod.GET)
    public ModelAndView getSchool(@PathVariable("id") Long school, Model model) {
        SchoolBean skl = uiSchoolServiceImpl.getSchool(school);
        model.addAttribute("schoolBean", skl);
        model.addAttribute("gradeLevelBeans",uiSchoolServiceImpl.getAvailableGradeLevels());
        return new ModelAndView("system/school/school");
    }
    
}
