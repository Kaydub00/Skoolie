/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.school.classschedule;

import com.dub.skoolie.structures.schedule.GradingPeriodBean;
import com.dub.skoolie.web.service.schedule.UiGradingPeriodService;
import java.util.Collections;
import java.util.Comparator;
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
public class SystemSchoolClassScheduleController {
    
    @Autowired
    UiGradingPeriodService uiGradingPeriodServiceImpl;
    
    //Giving the user a list of the grading periods so they can choose which grading period class schedule to review
    @RequestMapping(value="/system/schools/{id}/classes",method=RequestMethod.GET)
    public ModelAndView getClassSchedule(@PathVariable("id") Long school, Model model) {
        List<GradingPeriodBean> gpblist = uiGradingPeriodServiceImpl.getGradingPeriodBySchoolId(school);
        //let's sort the gradingperiodbeans by their startDate
        Collections.sort(gpblist, new Comparator<GradingPeriodBean>() {
            public int compare(GradingPeriodBean gpb1, GradingPeriodBean gpb2) {
                return gpb1.getStartDate().compareTo(gpb2.getStartDate());
            }
        });
        model.addAttribute("gradingPeriodBeans", gpblist);
        return new ModelAndView("/system/school/classschedule/index");
    }
    
    @RequestMapping(value="/system/schools/{id}/classes/{gpid}",method=RequestMethod.GET)
    public ModelAndView getClassScheduleByGradingPeriod(Model model) {
        //get current grading period as well as last grading period and next grading period, you'll need these to navigate to the next and previous grading period
        return new ModelAndView("/system/school/classschedule/gradingperiod");
    }
    
}
