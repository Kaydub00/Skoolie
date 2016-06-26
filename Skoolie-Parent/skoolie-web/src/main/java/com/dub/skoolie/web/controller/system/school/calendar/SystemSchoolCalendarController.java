/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.school.calendar;

import com.dub.skoolie.structures.school.SchoolBean;
import com.dub.skoolie.web.service.school.UiSchoolService;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
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
public class SystemSchoolCalendarController {
    
    @Autowired
    UiSchoolService uiSchoolServiceImpl;
    
    @RequestMapping(value="/system/schools/{id}/calendar", method=RequestMethod.GET)
    public ModelAndView getSchool(@PathVariable("id") Long school, Model model) {
        SchoolBean schoolBean = uiSchoolServiceImpl.getSchool(school);
        model.addAttribute("schoolBean", schoolBean);
        return new ModelAndView("system/school/calendar/schoolcalendar");
    }
    
    //@RequestMapping(value="/system/schools/events/{id}", method=RequestMethod.GET)
    public @ResponseBody String getSchoolEvents(@PathVariable("id") Long school) {
        JsonObjectBuilder object = Json.createObjectBuilder().add("id", "1").add("title", "Test event").add("allDay", "").add("end", "2016-06-06 14:00:00").add("start","2016-06-06 12:00:00");
        JsonObjectBuilder object2 = Json.createObjectBuilder().add("id", "2").add("title", "Test event 2").add("allDay", "").add("end", "2016-06-26 14:00:00").add("start","2016-06-26 12:00:00");
        
        JsonArray array = Json.createArrayBuilder().add(object).add(object2).build();
        return array.toString();
    }
    
}
