/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.courses;

import com.dub.skoolie.structures.courses.CourseBean;
import com.dub.skoolie.web.service.courses.UiCourseService;
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
public class SystemCourseController {
    
    @Autowired
    UiCourseService uiCourseServiceImpl;
    
    @RequestMapping(value="/system/courses", method=RequestMethod.GET)
    public ModelAndView getCourses(Model model) {
        model.addAttribute("courseBeans", uiCourseServiceImpl.getCourses());
        return new ModelAndView("system/courses/courses");
    }
    
    @RequestMapping(value="/system/courses/{course}", method=RequestMethod.GET)
    public ModelAndView getCourse(@PathVariable("course") Long course, Model model) {
        CourseBean courseBean = uiCourseServiceImpl.getCourse(course);
        model.addAttribute("courseBean", courseBean);
        return new ModelAndView("system/courses/course");
    }
    
    @RequestMapping(value="/system/courses", method=RequestMethod.POST)
    public ModelAndView addCourse(@Valid CourseBean courseBean, BindingResult result, Model model, HttpServletRequest request) {
        String referrer = request.getHeader("Referer");
        if(result.hasErrors()) {
            if(!referrer.equals("/system/subjects")) {
                return new ModelAndView("redirect:" + referrer);
            }
        }
        uiCourseServiceImpl.addCourse(courseBean);
        return new ModelAndView("redirect:" + referrer);
    }
    
}
