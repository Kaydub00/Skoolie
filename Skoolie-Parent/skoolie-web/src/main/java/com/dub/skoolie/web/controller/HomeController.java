
package com.dub.skoolie.web.controller;

import com.dub.skoolie.structures.usr.security.UserBean;
import com.dub.skoolie.web.service.usr.security.UiUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    
    @Autowired
    UiUserService uiUserServiceImpl;
    
    @RequestMapping("/index")
    public ModelAndView index(Model model) {
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserBean user = uiUserServiceImpl.getUser(userDetails.getUsername());
        if(user.getType().equals("SYSTEM")) {
            return new ModelAndView("redirect:/system");
        } else if (user.getType().equals("TEACHER")) {
            return new ModelAndView("redirect:/teacher");
        } else if (user.getType().equals("STUDENT")) {
            return new ModelAndView("redirect:/student");
        } else if (user.getType().equals("PARENT")) {
            return new ModelAndView("redirect:/parent");
        } else if (user.getType().equals("ADMIN") || user.getType().equals("DISTRICT_ADMIN") || user.getType().equals("SCHOOL_ADMIN")) {
            return new ModelAndView("redirect:/admin");
        }
        //model.addAttribute("homebean", homeBean);
        return new ModelAndView("home");
    }
    
    @RequestMapping("/test")
    public ModelAndView system(Model model) {
        List<UserBean> users = uiUserServiceImpl.getUsers();
        model.addAttribute("users", users);
        return new ModelAndView("testpage");
    }
    
    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

}
