
package com.dub.skoolie.web.controller.admin;

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
 * @author Kevin W.
 */
@Controller
public class AdminUserController {
    
    @Autowired
    UiUserService uiUserServiceImpl;
    
    @RequestMapping("/admin/users")
    public ModelAndView getUsers(Model model) {
        List<UserBean> users = uiUserServiceImpl.getUsers();
        return new ModelAndView("admin/users");
    }

}
