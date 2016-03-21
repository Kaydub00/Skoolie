
package com.dub.skoolie.web.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin W.
 */
@Controller
public class AdminController {
    
    @RequestMapping("/admin")
    public ModelAndView index(Model model) {
        return new ModelAndView("admin/index");
    }
}
