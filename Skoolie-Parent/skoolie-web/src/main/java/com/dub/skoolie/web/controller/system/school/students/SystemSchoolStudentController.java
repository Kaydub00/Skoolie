/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.school.students;

import com.dub.skoolie.structures.people.students.StudentBean;
import com.dub.skoolie.web.service.people.students.UiStudentService;
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
public class SystemSchoolStudentController {
    
    @Autowired
    UiStudentService uiStudentServiceImpl;
    
    @RequestMapping(value="/system/schools/{id}/students", method=RequestMethod.GET)
    public ModelAndView getStudents(@PathVariable("id") Long school, Model model) {
        List<StudentBean> studentBeans = uiStudentServiceImpl.getStudentsBySchool(school);
        return new ModelAndView("system/people/students/students");
    }
    
}
