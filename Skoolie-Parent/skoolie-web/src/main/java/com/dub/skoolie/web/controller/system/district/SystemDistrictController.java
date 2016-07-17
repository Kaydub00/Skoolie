/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.district;

import com.dub.skoolie.structures.district.DistrictBean;
import com.dub.skoolie.web.service.district.UiDistrictService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin W
 */
@Controller
public class SystemDistrictController {
    
    @Autowired
    UiDistrictService uiDistrictServiceImpl;
    
    
    @RequestMapping(value="/system/districts", method=RequestMethod.GET)
    public ModelAndView getDistricts(Model model) {
        model.addAttribute("districts", uiDistrictServiceImpl.getDistricts());
        model.addAttribute("districtBean", new DistrictBean());
        return new ModelAndView("system/district/districts");
    }
    
    @RequestMapping(value="/system/districts", method=RequestMethod.POST)
    public ModelAndView addDistrict(@Valid DistrictBean districtBean, BindingResult result, Model model, HttpServletRequest request) {
        String referrer = request.getHeader("Referer");
        if(result.hasErrors()) {
            if(!referrer.equals("/system/districts")) {
                return new ModelAndView("redirect:" + referrer);
            }
            model.addAttribute("districtBean", districtBean);
            model.addAttribute("districts", uiDistrictServiceImpl.getDistricts());
            return new ModelAndView("system/district/districts");
        }
        uiDistrictServiceImpl.addDistrict(districtBean);
        return new ModelAndView("redirect:" + referrer);
    }
    
    @RequestMapping(value="/system/districts/{id}", method=RequestMethod.GET)
    public ModelAndView getDistrict(@PathVariable("id") Long district, Model model) {
        DistrictBean db = uiDistrictServiceImpl.getDistrict(district);
        model.addAttribute("districtBean", db);
        return new ModelAndView("system/district/districts");
    }
}
