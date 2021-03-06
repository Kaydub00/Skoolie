/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.school.teachers;

import com.dub.skoolie.structures.people.faculty.TeacherBean;
import com.dub.skoolie.web.service.people.faculty.UiTeacherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kevinw
 */
@Controller
public class SystemSchoolTeacherController {
    
    @Autowired
    UiTeacherService uiTeacherServiceImpl;
    
    @RequestMapping(value="/system/schools/{id}/teachers", method=RequestMethod.GET)
    public ModelAndView getSchool(@PathVariable("id") Long school, Model model) {
        List<TeacherBean> teacherBeans = uiTeacherServiceImpl.getTeachersBySchool(school);
        return new ModelAndView("system/people/faculty/teachers");
    }
    
}
