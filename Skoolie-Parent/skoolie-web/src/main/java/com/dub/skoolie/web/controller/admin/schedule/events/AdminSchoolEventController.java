/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.admin.schedule.events;

import com.dub.skoolie.structures.schedule.events.SchoolEventBean;
import com.dub.skoolie.web.service.schedule.events.UiSchoolEventService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
public class AdminSchoolEventController {
    
    @Autowired
    UiSchoolEventService uiSchoolEventServiceImpl;
    
    @RequestMapping(value="/admin/schedule/events/school", method=RequestMethod.POST)
    public ModelAndView addSchoolEvent(@Valid SchoolEventBean schoolEventBean, BindingResult result, Model model, HttpServletRequest request) {
        String referrer = request.getHeader("Referer");
        if(result.hasErrors()) {
            if(!referrer.equals("/admin/schedule/events/school")) {
                return new ModelAndView("redirect:" + referrer);
            }
            return new ModelAndView("admin/schedule/events/index");
        }
        uiSchoolEventServiceImpl.addSchoolEvent(schoolEventBean);
        return new ModelAndView("admin/schedule/events/index");
    }
    
    @RequestMapping(value="/admin/schedule/events/school/{id}", method=RequestMethod.GET)
    public @ResponseBody String getSchoolEvents(@PathVariable("id") Long school) throws JsonProcessingException {
        List<SchoolEventBean> schoolEventBeans = uiSchoolEventServiceImpl.getSchoolEventsBySchool(school);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(schoolEventBeans);
    }
    
}
