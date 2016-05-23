/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.people.faculty;

import com.dub.skoolie.structures.people.faculty.DistrictAdminBean;
import com.dub.skoolie.web.service.people.faculty.UiDistrictAdminService;
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
public class SystemDistrictAdminController {
    
    @Autowired
    UiDistrictAdminService uiDistrictAdminServiceImpl;
    
    @RequestMapping(value="/system/people/faculty/districtadmin", method=RequestMethod.GET)
    public ModelAndView getDistrictAdmins(Model model) {
        
        return new ModelAndView("");
    }
    
    @RequestMapping(value="/system/people/faculty/districtadmin/{username}", method=RequestMethod.GET)
    public ModelAndView getDistrictAdmin(@PathVariable("username") String username, Model model) {
        return new ModelAndView("");
    }
    
    @RequestMapping(value="/system/people/faculty/districtadmin", method=RequestMethod.POST)
    public ModelAndView addDistrictAdmin(@Valid DistrictAdminBean districtAdminBean, BindingResult result, Model model, HttpServletRequest request) {
        String referrer = request.getHeader("Referer");
        if(result.hasErrors()) {
            if(!referrer.equals("/system/people/faculty/districtadmin")) {
                return new ModelAndView("redirect:" + referrer);
            }
        }
        uiDistrictAdminServiceImpl.addDistrictAdmin(districtAdminBean);
        return new ModelAndView("");
    }
    
}
