/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.school.gradelevel;

import com.dub.skoolie.structures.school.GradeLevelBean;
import com.dub.skoolie.structures.school.SchoolBean;
import com.dub.skoolie.web.service.school.UiGradeLevelService;
import com.dub.skoolie.web.service.school.UiSchoolService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kevinw
 */
@Controller
public class SystemSchoolGradeLevelController {
    
    @Autowired
    UiSchoolService uiSchoolServiceImpl;
    
    @Autowired
    UiGradeLevelService uiGradeLevelService;
    
    //should create a form object here and validate it, but going to use requestparams for now
    @RequestMapping(value="/system/schools/{schoolid}/gradelevel", method=RequestMethod.POST)
    public ModelAndView addGradeLevelToSchool(@PathVariable("schoolid") Long school, @RequestParam("gradeLevel") String gradeLevel, Model model, HttpServletRequest request) {
        String referrer = request.getHeader("Referer");
        SchoolBean schoolBean = uiSchoolServiceImpl.getSchool(school);
        List<GradeLevelBean> gradeLevels = schoolBean.getGradeLevels();
        GradeLevelBean newGradeLevel = uiGradeLevelService.getGradeLevel(Long.parseLong(gradeLevel));
        if(gradeLevels.isEmpty()) {
            gradeLevels.add(newGradeLevel);
            schoolBean.setGradeLevels(gradeLevels);
            uiSchoolServiceImpl.updateSchool(schoolBean);
            return new ModelAndView("redirect:" + referrer);
        }
        for(GradeLevelBean glb : gradeLevels) {
            if(glb.getLevel().equals(newGradeLevel.getLevel())) {
                return new ModelAndView("redirect:" + referrer);
            }
        }
        gradeLevels.add(newGradeLevel);
        schoolBean.setGradeLevels(gradeLevels);
        uiSchoolServiceImpl.updateSchool(schoolBean);
        return new ModelAndView("redirect:" + referrer);
    }
}
