/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.school.classschedule;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kevinw
 */
@Controller
public class SystemSchoolClassScheduleController {
    
    @RequestMapping(value="/system/school/{id}/classes",method=RequestMethod.GET)
    public ModelAndView getClassSchedule(Model model) {
        //get current grading period and redirect to the method below
        return new ModelAndView("/system/school/classschedule/index");
    }
    
    @RequestMapping(value="/system/school/{id}/classes/{gpid}",method=RequestMethod.GET)
    public ModelAndView getClassScheduleByGradingPeriod(Model model) {
        //get current grading period as well as last grading period and next grading period, you'll need these to navigate to the next and previous grading period
        return new ModelAndView("/system/school/classschedule/index");
    }
    
}
