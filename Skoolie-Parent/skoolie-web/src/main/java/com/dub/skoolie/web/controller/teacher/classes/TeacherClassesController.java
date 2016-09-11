/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.teacher.classes;

import com.dub.skoolie.web.service.courses.UiSchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin W
 */
@Controller
public class TeacherClassesController {
    
    @Autowired
    UiSchoolClassService uiSchoolClassServiceImpl;
    
    
    @RequestMapping(value="/teacher/classes", method=RequestMethod.GET)
    public ModelAndView getTeacherClasses(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("schoolClassBeans", uiSchoolClassServiceImpl.getTeacherCurrentClasses(auth.getName()));
        return new ModelAndView("teacher/classes/index");
    }
    
    @RequestMapping(value="/teacher/classes/{id}", method=RequestMethod.GET)
    public ModelAndView getTeacherClass(@PathVariable("id") Long schoolClass, Model model) {
        model.addAttribute("schoolClassBean", uiSchoolClassServiceImpl.getSchoolClass(schoolClass));
        return new ModelAndView("teacher/classes/class");
    }
}
