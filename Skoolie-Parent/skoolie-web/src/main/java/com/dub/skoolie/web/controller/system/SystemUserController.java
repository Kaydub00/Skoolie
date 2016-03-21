/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system;

import com.dub.skoolie.structures.usr.security.UserBean;
import com.dub.skoolie.web.service.usr.security.UiUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gaming
 */
@Controller
public class SystemUserController {
    
    @Autowired
    UiUserService uiUserServiceImpl;
    
    @RequestMapping("/system/users")
    public ModelAndView getUsers(Model model) {
        List<UserBean> users = uiUserServiceImpl.getUsers();
        model.addAttribute("users", users);
        return new ModelAndView("admin/users");
    }
    
}
