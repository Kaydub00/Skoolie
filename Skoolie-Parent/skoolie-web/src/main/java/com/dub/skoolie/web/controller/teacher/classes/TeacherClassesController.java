/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.teacher.classes;

import com.dub.skoolie.web.service.courses.UiSchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        String teacherName = "teacher";
        model.addAttribute("schoolClassBeans", uiSchoolClassServiceImpl.getTeacherCurrentClasses(teacherName));
        return new ModelAndView("teacher/classes/index");
    }
}
