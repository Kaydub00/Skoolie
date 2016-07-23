/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.schedule.events;

import com.dub.skoolie.structures.schedule.events.DistrictEventBean;
import com.dub.skoolie.web.service.schedule.events.UiDistrictEventService;
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
public class SystemDistrictEventController {
    
    @Autowired
    UiDistrictEventService uiDistrictEventServiceImpl;
    
    @RequestMapping(value="/system/schedule/events/district", method=RequestMethod.POST)
    public ModelAndView addDistrictEvent(@Valid DistrictEventBean districtEventBean, BindingResult result, Model model, HttpServletRequest request) {
        String referrer = request.getHeader("Referer");
        if(result.hasErrors()) {
            if(!referrer.equals("/system/schedule/events/district")) {
                return new ModelAndView("redirect:" + referrer);
            }
            return new ModelAndView("system/schedule/events/index");
        }
        uiDistrictEventServiceImpl.addDistrictEvent(districtEventBean);
        return new ModelAndView("system/schedule/events/index");
    }
    
    @RequestMapping(value="/system/schedule/events/district/{id}", method=RequestMethod.GET)
    public @ResponseBody String getDistrictEvents(@PathVariable("id") Long district) throws JsonProcessingException {
        List<DistrictEventBean> districtEventBeans = uiDistrictEventServiceImpl.getDistrictEventsByDistrict(district);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //JsonObjectBuilder object = Json.createObjectBuilder().add("id", "1").add("title", "Test event").add("allDay", "").add("end", "2016-06-06 14:00:00").add("start","2016-06-06 12:00:00");
        //JsonObjectBuilder object2 = Json.createObjectBuilder().add("id", "2").add("title", "Test event 2").add("allDay", "").add("end", "2016-06-26 14:00:00").add("start","2016-06-26 12:00:00");
        ObjectMapper mapper = new ObjectMapper();
        //mapper.setDateFormat(df);
        //JsonArray array = Json.createArrayBuilder().add(object).add(object2).build();
        return mapper.writeValueAsString(districtEventBeans);
    }
    
}
