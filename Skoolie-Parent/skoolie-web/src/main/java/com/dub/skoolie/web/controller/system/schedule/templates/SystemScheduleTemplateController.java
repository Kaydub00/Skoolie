/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.schedule.templates;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin W
 */
@Controller
public class SystemScheduleTemplateController {
    
    @RequestMapping("/system/schedule/templates")
    public ModelAndView index(Model model) {
        return new ModelAndView("system/schedule/templates/index");
    }
}
