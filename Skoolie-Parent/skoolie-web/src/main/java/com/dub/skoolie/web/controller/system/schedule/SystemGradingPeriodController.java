/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.schedule;

import com.dub.skoolie.structures.schedule.GradingPeriodBean;
import com.dub.skoolie.web.service.schedule.UiGradingPeriodService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin W
 */
@Controller
public class SystemGradingPeriodController {
    
    @Autowired
    UiGradingPeriodService uiGradingPeriodServiceImpl;
    
    @RequestMapping(value="/system/schedule/gradingperiod", method=RequestMethod.GET)
    public ModelAndView getGradingPeriods(Model model) {
        model.addAttribute("gradingPeriodBeans", uiGradingPeriodServiceImpl.getGradingPeriods());
        model.addAttribute("gradingPeriodBean", new GradingPeriodBean());
        model.addAttribute("schoolYears", uiGradingPeriodServiceImpl.getSchoolYears());
        return new ModelAndView("system/schedule/gradingperiod");
    }
    
    @RequestMapping(value="/system/schedule/gradingperiod", method=RequestMethod.POST)
    public ModelAndView addGradingPeriod(@Valid GradingPeriodBean gradingPeriodBean, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("gradingPeriodBeans", uiGradingPeriodServiceImpl.getGradingPeriods());
            model.addAttribute("gradingPeriodBean", gradingPeriodBean);
            model.addAttribute("schoolYears", uiGradingPeriodServiceImpl.getSchoolYears());
            return new ModelAndView("system/schedule/gradingperiod");
        }
        uiGradingPeriodServiceImpl.addGradingPeriod(gradingPeriodBean);
        return new ModelAndView("redirect:/system/schedule/gradingperiod");
    }
    
    @RequestMapping(value="/system/schedule/gradingperiod/delete", method=RequestMethod.POST)
    public ModelAndView deleteClassTimeBlock(@RequestParam("gradingperiod") String id, Model model) {
        uiGradingPeriodServiceImpl.deleteGradingPeriod(Long.parseLong(id));
        return new ModelAndView("redirect:/system/schedule/gradingperiod");
    }
}
