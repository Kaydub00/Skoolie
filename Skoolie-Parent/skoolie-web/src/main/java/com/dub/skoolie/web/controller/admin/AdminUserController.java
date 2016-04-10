
package com.dub.skoolie.web.controller.admin;

import com.dub.skoolie.structures.usr.security.UserBean;
import com.dub.skoolie.web.service.usr.security.UiUserService;
import java.util.List;
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
 * @author Kevin W.
 */
@Controller
public class AdminUserController {
    
    @Autowired
    UiUserService uiUserServiceImpl;
    
    @RequestMapping(value="/admin/users", method=RequestMethod.GET)
    public ModelAndView getUsers(Model model) {
        List<UserBean> users = uiUserServiceImpl.getUsers();
        UserBean userBean = new UserBean();
        List<String> allusertypes = uiUserServiceImpl.getUserTypes();
        model.addAttribute("userBean", userBean);
        model.addAttribute("users", users);
        model.addAttribute("allUserTypes", allusertypes);
        return new ModelAndView("admin/users");
    }
    
    @RequestMapping(value="/admin/users", method=RequestMethod.POST)
    public ModelAndView addUser(@Valid UserBean userBean, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("userBean", userBean);
            model.addAttribute("users", uiUserServiceImpl.getUsers());
            model.addAttribute("allUserTypes", uiUserServiceImpl.getUserTypes());
            return new ModelAndView("admin/users");
        }
        uiUserServiceImpl.addUser(userBean);
        return new ModelAndView("redirect:/admin/users/" + userBean.getUsername());
    }
    
    @RequestMapping(value="/admin/users/{username}", method=RequestMethod.GET)
    public ModelAndView getUser(@PathVariable("username") String username, Model model) {
        UserBean user = uiUserServiceImpl.getUser(username);
        model.addAttribute("user", user);
        return new ModelAndView("admin/user");
    }

}
