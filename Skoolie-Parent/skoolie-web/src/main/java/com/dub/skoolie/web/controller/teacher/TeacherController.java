
package com.dub.skoolie.web.controller.teacher;

import com.dub.skoolie.web.service.courses.UiSchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin W.
 */
@Controller
public class TeacherController {
    
    @Autowired
    UiSchoolClassService uiSchoolClassServiceImpl;
    
    @RequestMapping("/teacher")
    public ModelAndView index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("schoolClassBeans", uiSchoolClassServiceImpl.getTeacherCurrentClasses(auth.getName()));
        return new ModelAndView("teacher/index");
    }

}
