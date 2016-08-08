
package com.dub.skoolie.web.controller.teacher;

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
    
    @RequestMapping("/teacher")
    public ModelAndView index(Model model) {
        return new ModelAndView("teacher/index");
    }

}
