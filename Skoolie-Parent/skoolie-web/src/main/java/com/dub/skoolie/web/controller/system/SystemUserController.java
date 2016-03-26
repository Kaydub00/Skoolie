/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system;

import com.dub.skoolie.structures.usr.security.UserBean;
import com.dub.skoolie.structures.usr.security.UserTypeBean;
import com.dub.skoolie.web.service.usr.security.UiUserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gaming
 */
@Controller
public class SystemUserController {
    
    @Autowired
    UiUserService uiUserServiceImpl;
    
    @RequestMapping(value="/system/users", method=RequestMethod.GET)
    public ModelAndView getUsers(Model model) {
        List<UserBean> users = uiUserServiceImpl.getUsers();
        UserBean newuser = new UserBean();
        List<String> allusertypes = uiUserServiceImpl.getUserTypes();
        model.addAttribute("newuser", newuser);
        model.addAttribute("users", users);
        model.addAttribute("allUserTypes", allusertypes);
        return new ModelAndView("system/users");
    }
    
    @RequestMapping(value="/system/users", method=RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute UserBean user, Model model) {
        uiUserServiceImpl.addUser(user);
        return new ModelAndView("redirect:/system/users/" + user.getUsername());
    }
    
    @RequestMapping(value="/system/users/{username}", method=RequestMethod.GET)
    public ModelAndView getUser(@PathVariable("username") String username, Model model) {
        UserBean user = uiUserServiceImpl.getUser(username);
        model.addAttribute("user", user);
        return new ModelAndView("system/user");
    }
    
}
