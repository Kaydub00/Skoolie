/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.people.students;

import com.dub.skoolie.structures.people.students.StudentBean;
import com.dub.skoolie.web.service.people.students.UiStudentService;
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
public class SystemStudentController {
    
    @Autowired
    UiStudentService uiStudentServiceImpl;
    
    @RequestMapping(value="/system/people/students/student", method=RequestMethod.GET)
    public ModelAndView getStudents(Model model) {
        
        return new ModelAndView("");
    }
    
    @RequestMapping(value="/system/people/students/student/{username}", method=RequestMethod.GET)
    public ModelAndView getStudent(@PathVariable("username") String username, Model model) {
        return new ModelAndView("");
    }
    
    @RequestMapping(value="/system/people/students/student", method=RequestMethod.POST)
    public ModelAndView addDistrictAdmin(@Valid StudentBean studentBean, BindingResult result, Model model, HttpServletRequest request) {
        String referrer = request.getHeader("Referer");
        if(result.hasErrors()) {
            if(!referrer.equals("/system/people/students/student")) {
                return new ModelAndView("redirect:" + referrer);
            }
        }
        uiStudentServiceImpl.addStudent(studentBean);
        return new ModelAndView("redirect:" + referrer);
    }
    
}
