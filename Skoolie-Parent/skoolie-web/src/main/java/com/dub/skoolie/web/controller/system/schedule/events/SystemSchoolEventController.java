/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.schedule.events;

import com.dub.skoolie.structures.schedule.events.SchoolEventBean;
import com.dub.skoolie.web.service.schedule.events.UiSchoolEventService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
public class SystemSchoolEventController {
    
    @Autowired
    UiSchoolEventService uiSchoolEventServiceImpl;
    
    @RequestMapping(value="/system/schedule/events/school", method=RequestMethod.POST)
    public ModelAndView addSchoolEvent(@Valid SchoolEventBean schoolEventBean, BindingResult result, Model model, HttpServletRequest request) {
        String referrer = request.getHeader("Referer");
        if(result.hasErrors()) {
            for ( ObjectError err : result.getAllErrors()) {
                System.out.println(err.getDefaultMessage());
            }
            if(!referrer.equals("/system/schedule/events/school")) {
                return new ModelAndView("redirect:" + referrer);
            }
            return new ModelAndView("system/schedule/events/index");
        }
        uiSchoolEventServiceImpl.addSchoolEvent(schoolEventBean);
        return new ModelAndView("system/schedule/events/index");
    }
    
    @RequestMapping(value="/system/schedule/events/school/{id}", method=RequestMethod.GET)
    public @ResponseBody String getSchoolEvents(@PathVariable("id") Long school) throws JsonProcessingException {
        List<SchoolEventBean> schoolEventBeans = uiSchoolEventServiceImpl.getSchoolEventsBySchool(school);
        //JsonObjectBuilder object = Json.createObjectBuilder().add("id", "1").add("title", "Test event").add("allDay", "").add("end", "2016-06-06 14:00:00").add("start","2016-06-06 12:00:00");
        //JsonObjectBuilder object2 = Json.createObjectBuilder().add("id", "2").add("title", "Test event 2").add("allDay", "").add("end", "2016-06-26 14:00:00").add("start","2016-06-26 12:00:00");
        ObjectMapper mapper = new ObjectMapper();
        //JsonArray array = Json.createArrayBuilder().add(object).add(object2).build();
        return mapper.writeValueAsString(schoolEventBeans);
    }
    
}
