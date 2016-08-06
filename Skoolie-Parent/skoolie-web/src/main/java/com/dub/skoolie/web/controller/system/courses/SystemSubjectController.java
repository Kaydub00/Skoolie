/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system.courses;

import com.dub.skoolie.structures.courses.SubjectBean;
import com.dub.skoolie.web.service.courses.UiSubjectService;
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
public class SystemSubjectController {
    
    //@Autowired
    UiSubjectService uiSubjectServiceImpl;
    
    @RequestMapping(value="/system/subjects", method=RequestMethod.GET)
    public ModelAndView getSubjects(Model model) {
        return new ModelAndView("test");
    }
    
    @RequestMapping(value="/system/subjects/{subject}", method=RequestMethod.GET)
    public ModelAndView getSubject(@PathVariable("subject") String subject, Model model) {
        return new ModelAndView("");
    }
    
    @RequestMapping(value="/system/subjects", method=RequestMethod.POST)
    public ModelAndView addSubject(@Valid SubjectBean subjectBean, BindingResult result, Model model, HttpServletRequest request) {
        String referrer = request.getHeader("Referer");
        if(result.hasErrors()) {
            if(!referrer.equals("/system/subjects")) {
                return new ModelAndView("redirect:" + referrer);
            }
        }
        uiSubjectServiceImpl.addSubject(subjectBean);
        return new ModelAndView("redirect:" + referrer);
    }
    
}
