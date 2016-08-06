/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.school.courses;

import com.dub.skoolie.web.service.courses.UiCourseService;
import com.dub.skoolie.web.service.courses.UiSubjectService;
import com.dub.skoolie.web.service.school.UiSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SystemSchoolCoursesIndexController {
    
    @Autowired
    UiSchoolService uiSchoolServiceImpl;
    
    @Autowired
    UiSubjectService uiSubjectServiceImpl;
    
    @Autowired
    UiCourseService uiCourseServiceImpl;
    
    @RequestMapping(value="/system/schools/{id}/coursesidx", method=RequestMethod.GET)
    public ModelAndView getSchoolCoursesIndex(@PathVariable("id") Long school, Model model) {
        model.addAttribute("schoolBean", uiSchoolServiceImpl.getSchool(school));
        model.addAttribute("subjectBeans", uiSubjectServiceImpl.getSubjectsBySchool(school));
        model.addAttribute("courseBeans", uiCourseServiceImpl.getCoursesBySchool(school));
        return new ModelAndView("system/school/courses/index");
    }
    
}
