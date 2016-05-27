/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.people.faculty;

import com.dub.skoolie.structures.people.faculty.SchoolAdminBean;
import com.dub.skoolie.web.service.people.faculty.UiSchoolAdminService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin W
 */
@Controller
public class SystemSchoolAdminController {
    
    @Autowired
    UiSchoolAdminService uiSchoolAdminServiceImpl;
    
    @RequestMapping(value="/system/people/faculty/schooladmin", method=RequestMethod.GET)
    public ModelAndView getSchoolAdmins(Model model) {
        
        return new ModelAndView("");
    }
    
    @RequestMapping(value="/system/people/faculty/schooladmin/{username}", method=RequestMethod.GET)
    public ModelAndView getSchoolAdmin(@PathVariable("username") String username, Model model) {
        return new ModelAndView("");
    }
    
    @RequestMapping(value="/system/people/faculty/schooladmin", method=RequestMethod.POST)
    public ModelAndView addSchoolAdmin(@Valid SchoolAdminBean schoolAdminBean, BindingResult result, Model model, HttpServletRequest request) {
        String referrer = request.getHeader("Referer");
        if(result.hasErrors()) {
            if(!referrer.equals("/system/people/faculty/schooladmin")) {
                return new ModelAndView("redirect:" + referrer);
            }
        }
        uiSchoolAdminServiceImpl.addSchoolAdmin(schoolAdminBean);
        return new ModelAndView("redirect:" + referrer);
    }
    
}
