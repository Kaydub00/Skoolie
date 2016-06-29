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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public ModelAndView getSchool(@PathVariable("id") Long school, Model model) {
        SchoolBean skl = uiSchoolServiceImpl.getSchool(school);
        model.addAttribute("schoolBean", skl);
        List<SchoolRoomBean> rms = uiSchoolRoomServiceImpl.getSchoolRoomsBySchool(school);
        model.addAttribute("schoolRoomBeans", rms);
        return new ModelAndView("system/school/rooms/index");
    }
    
}
