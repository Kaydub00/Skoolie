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
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin W
 */
@Controller
public class SystemUserController {
    
    @Autowired
    UiUserService uiUserServiceImpl;
    
    @RequestMapping(value="/system/users", method=RequestMethod.GET)
    public ModelAndView getUsers(Model model) {
        List<UserBean> users = uiUserServiceImpl.getUsers();
        UserBean userBean = new UserBean();
        List<String> allusertypes = uiUserServiceImpl.getUserTypes();
        model.addAttribute("userBean", userBean);
        model.addAttribute("users", users);
        model.addAttribute("allUserTypes", allusertypes);
        return new ModelAndView("system/users");
    }
    
    @RequestMapping(value="/system/users", method=RequestMethod.POST)
    public ModelAndView addUser(@Valid UserBean userBean, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("userBean", userBean);
            model.addAttribute("users", uiUserServiceImpl.getUsers());
            model.addAttribute("allUserTypes", uiUserServiceImpl.getUserTypes());
            return new ModelAndView("system/users");
        }
        uiUserServiceImpl.addUser(userBean);
        return new ModelAndView("redirect:/system/users/" + userBean.getUsername());
    }
    
    @RequestMapping(value="/system/users/{username}", method=RequestMethod.GET)
    public ModelAndView getUser(@PathVariable("username") String username, Model model) {
        UserBean user = uiUserServiceImpl.getUser(username);
        model.addAttribute("user", user);
        return new ModelAndView("system/user");
    }
    
}
