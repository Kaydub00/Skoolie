/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.school.courses;

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
public class SystemSchoolCoursesIndexController {
    
    @RequestMapping(value="/system/schools/{id}/coursesidx", method=RequestMethod.GET)
    public ModelAndView getSchoolCoursesIndex(Model model) {
        return new ModelAndView("system/school/courses/index");
    }
    
}
