
package com.dub.skoolie.web.controller.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin W.
 */
@Controller
public class StudentController {
    
    @RequestMapping("/student")
    public ModelAndView index(Model model) {
        return new ModelAndView("student/index");
    }

}
