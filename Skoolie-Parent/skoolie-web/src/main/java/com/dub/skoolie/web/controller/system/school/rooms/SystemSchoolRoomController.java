/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.school.rooms;

import com.dub.skoolie.structures.school.SchoolBean;
import com.dub.skoolie.structures.school.SchoolRoomBean;
import com.dub.skoolie.web.service.school.UiSchoolRoomService;
import com.dub.skoolie.web.service.school.UiSchoolService;
import com.dub.skoolie.web.service.school.impl.UiSchoolRoomServiceImpl;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin W
 */
@Controller
public class SystemSchoolRoomController {
    
    @Autowired
    UiSchoolRoomService uiSchoolRoomServiceImpl;
    
    @Autowired
    UiSchoolService uiSchoolServiceImpl;
    
    
    @RequestMapping(value="/system/schools/{id}/rooms", method=RequestMethod.GET)
    public ModelAndView getSchoolRooms(@PathVariable("id") Long school, Model model) {
        SchoolBean skl = uiSchoolServiceImpl.getSchool(school);
        model.addAttribute("schoolBean", skl);
        List<SchoolRoomBean> rms = uiSchoolRoomServiceImpl.getSchoolRoomsBySchool(school);
        model.addAttribute("schoolRoomBeans", rms);
        model.addAttribute("schoolRoomBean", new SchoolRoomBean());
        return new ModelAndView("system/school/rooms/index");
    }
    
    @RequestMapping(value="/system/schools/{id}/rooms", method=RequestMethod.POST)
    public ModelAndView addSchoolRoom(@PathVariable("id") Long schoolid, @Valid SchoolRoomBean schoolRoomBean, BindingResult result, Model model, HttpServletRequest request) {
        String referrer = request.getHeader("Referer");
        if(result.hasErrors()) {
            if(!referrer.equals("/system/schools/" + schoolid + "/rooms")) {
                return new ModelAndView("redirect:" + referrer);
            }
            return new ModelAndView("system/school/schools");
        }
        uiSchoolRoomServiceImpl.addSchoolRoom(schoolRoomBean);
        return new ModelAndView("redirect:" + referrer);
    }
    
    @RequestMapping(value="/system/schools/{id}/rooms/delete", method=RequestMethod.POST)
    public ModelAndView deleteSchoolRoom(@PathVariable("id") Long schoolid,@RequestParam("roomid") String roomid, HttpServletRequest request) {
        String referrer = request.getHeader("Referer");
        uiSchoolRoomServiceImpl.deleteSchoolRoom(Long.parseLong(roomid));
        return new ModelAndView("redirect:" + referrer);
    }
    
}
