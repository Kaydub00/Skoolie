/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.schedule.events;

import com.dub.skoolie.structures.schedule.events.UserEventBean;
import com.dub.skoolie.web.service.schedule.events.UiUserEventService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin W
 */
@Controller
public class SystemUserEventController {
    
    @Autowired
    UiUserEventService uiUserEventServiceImpl;
    
    @RequestMapping(value="/system/schedule/events/user", method=RequestMethod.POST)
    public ModelAndView addUserEvent(@Valid UserEventBean userEventBean, BindingResult result, Model model, HttpServletRequest request) {
        String referrer = request.getHeader("Referer");
        if(result.hasErrors()) {
            if(!referrer.equals("/system/schedule/events/user")) {
                return new ModelAndView("redirect:" + referrer);
            }
            return new ModelAndView("system/schedule/events/index");
        }
        uiUserEventServiceImpl.addUserEvent(userEventBean);
        return new ModelAndView("system/schedule/events/index");
    }
    
}
