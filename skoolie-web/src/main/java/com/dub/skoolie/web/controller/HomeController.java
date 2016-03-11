
package com.dub.skoolie.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin W.
 */
@Controller
public class HomeController {
    
    @RequestMapping("/index")
    public ModelAndView index(Model model)
    {
        //UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //model.addAttribute("homebean", homeBean);
        return new ModelAndView("home");
    }

}
