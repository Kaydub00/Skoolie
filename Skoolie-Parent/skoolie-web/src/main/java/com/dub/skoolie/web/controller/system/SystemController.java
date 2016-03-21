/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gaming
 */
@Controller
public class SystemController {
    
    @RequestMapping("/system")
    public ModelAndView index(Model model) {
        return new ModelAndView("system/index");
    }
    
}
