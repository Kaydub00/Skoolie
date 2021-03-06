/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.admin.school.calendar;

import com.dub.skoolie.structures.schedule.GradingPeriodBean;
import com.dub.skoolie.structures.schedule.SchoolYearBean;
import com.dub.skoolie.structures.school.SchoolBean;
import com.dub.skoolie.web.service.schedule.UiGradingPeriodService;
import com.dub.skoolie.web.service.schedule.UiSchoolYearService;
import com.dub.skoolie.web.service.school.UiSchoolService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin W
 */
@Controller
public class AdminSchoolCalendarController {
    
    @Autowired
    UiSchoolService uiSchoolServiceImpl;
    
    @Autowired
    UiSchoolYearService uiSchoolYearServiceImpl;
    
    @Autowired
    UiGradingPeriodService uiGradingPeriodServiceImpl;
    
    @RequestMapping(value="/admin/schools/{id}/calendar", method=RequestMethod.GET)
    public ModelAndView getSchool(@PathVariable("id") Long school, Model model) {
        SchoolBean schoolBean = uiSchoolServiceImpl.getSchool(school);
        model.addAttribute("schoolBean", schoolBean);
        return new ModelAndView("admin/school/calendar/schoolcalendar");
    }
    
    @RequestMapping(value="/admin/schools/{school}/calendar/schoolyear", method=RequestMethod.GET)
    public @ResponseBody String getSchoolYears(@PathVariable("school") Long id) throws JsonProcessingException {
        List<SchoolYearBean> schoolYearBeans = uiSchoolYearServiceImpl.getSchoolYearsBySchoolId(id);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(schoolYearBeans);
    }
    
    @RequestMapping(value="/admin/schools/{school}/calendar/gradingperiod", method=RequestMethod.GET)
    public @ResponseBody String getGradingPeriods(@PathVariable("school") Long id) throws JsonProcessingException {
        List<GradingPeriodBean> gradingPeriodBeans = uiGradingPeriodServiceImpl.getGradingPeriodBySchoolId(id);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(gradingPeriodBeans);
    }
}
