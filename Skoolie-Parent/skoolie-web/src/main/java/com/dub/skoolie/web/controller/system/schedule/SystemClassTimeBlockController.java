/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.schedule;

import com.dub.skoolie.structures.schedule.ClassTimeBlockBean;
import com.dub.skoolie.web.service.schedule.UiClassTimeBlockService;
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
public class SystemClassTimeBlockController {
    
    @Autowired
    UiClassTimeBlockService uiClassTimeBlockServiceImpl;
    
    @RequestMapping(value="/system/schedule/classtimeblock", method=RequestMethod.GET)
    public ModelAndView getClassTimeBlocks(Model model) {
        model.addAttribute("classTimeBlockBeans", uiClassTimeBlockServiceImpl.getClassTimeBlocks());
        model.addAttribute("classTimeBlockBean", new ClassTimeBlockBean());
        model.addAttribute("gradingPeriods", uiClassTimeBlockServiceImpl.getGradingPeriods());
        return new ModelAndView("system/schedule/classtimeblock");
    }
    
    @RequestMapping(value="/system/schedule/classtimeblock", method=RequestMethod.POST)
    public ModelAndView addClassTimeBlock(@Valid ClassTimeBlockBean classTimeBlockBean, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("classTimeBlockBeans", uiClassTimeBlockServiceImpl.getClassTimeBlocks());
            model.addAttribute("classTimeBlockBean", classTimeBlockBean);
            model.addAttribute("gradingPeriods", uiClassTimeBlockServiceImpl.getGradingPeriods());
            return new ModelAndView("system/schedule/classtimeblock");
        }
        uiClassTimeBlockServiceImpl.addClassTimeBlock(classTimeBlockBean);
        return new ModelAndView("redirect:/system/schedule/classtimeblock");
    }
    
    @RequestMapping(value="/system/schedule/classtimeblock/delete", method=RequestMethod.POST)
    public ModelAndView deleteClassTimeBlock(@RequestParam("classtimeblock") String id, Model model) {
        uiClassTimeBlockServiceImpl.deleteClassTimeBlock(Long.parseLong(id));
        return new ModelAndView("redirect:/system/schedule/classtimeblock");
    }
    
}
