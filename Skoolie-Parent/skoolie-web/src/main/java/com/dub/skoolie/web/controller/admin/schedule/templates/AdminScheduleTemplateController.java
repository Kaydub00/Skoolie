/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.admin.schedule.templates;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin W
 */
@Controller
public class AdminScheduleTemplateController {
    
    @RequestMapping("/admin/schedule/templates")
    public ModelAndView index(Model model) {
        return new ModelAndView("admin/schedule/templates/index");
    }
    
}
