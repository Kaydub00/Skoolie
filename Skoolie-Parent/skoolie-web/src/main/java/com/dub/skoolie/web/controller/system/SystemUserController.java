/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.controller.system;

import com.dub.skoolie.structures.people.faculty.DistrictAdminBean;
import com.dub.skoolie.structures.people.faculty.SchoolAdminBean;
import com.dub.skoolie.structures.people.faculty.TeacherBean;
import com.dub.skoolie.structures.people.parents.ParentBean;
import com.dub.skoolie.structures.people.students.StudentBean;
import com.dub.skoolie.structures.usr.security.UserBean;
import com.dub.skoolie.web.service.people.faculty.UiDistrictAdminService;
import com.dub.skoolie.web.service.people.faculty.UiSchoolAdminService;
import com.dub.skoolie.web.service.people.faculty.UiTeacherService;
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
 * @author Kevin W
 */
@Controller
public class SystemUserController {
    
    @Autowired
    UiUserService uiUserServiceImpl;
    
    @Autowired
    UiDistrictAdminService uiDistrictAdminServiceImpl;
    
    @Autowired
    UiSchoolAdminService uiSchoolAdminServiceImpl;
    
    @Autowired
    UiTeacherService uiTeacherServiceImpl;
    
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
        UserBean userBean = uiUserServiceImpl.getUser(username);
        model.addAttribute("userBean", userBean);
        //Different user types have different UI objects
        switch (userBean.getType()) {
            case "DISTRICT_ADMIN": 
                DistrictAdminBean districtAdminBean;
                if(null != uiDistrictAdminServiceImpl.getDistrictAdmin(userBean.getUsername())) {
                    districtAdminBean = uiDistrictAdminServiceImpl.getDistrictAdmin(userBean.getUsername());
                } else {
                    districtAdminBean = new DistrictAdminBean();
                    districtAdminBean.setUser(userBean);
                    districtAdminBean.setUsername(userBean.getUsername());
                }
                model.addAttribute("districtAdminBean", districtAdminBean);
                break;
            case "SCHOOL_ADMIN":
                SchoolAdminBean schoolAdminBean;
                if(null != uiSchoolAdminServiceImpl.getSchoolAdmin(userBean.getUsername())) {
                    schoolAdminBean = uiSchoolAdminServiceImpl.getSchoolAdmin(userBean.getUsername());
                } else {
                    schoolAdminBean = new SchoolAdminBean();
                    schoolAdminBean.setUser(userBean);
                    schoolAdminBean.setUsername(userBean.getUsername());
                }
                model.addAttribute("schoolAdminBean", schoolAdminBean);
                break;
            case "TEACHER":
                TeacherBean teacherBean;
                if(null != uiTeacherServiceImpl.getTeacher(userBean.getUsername())) {
                    teacherBean = uiTeacherServiceImpl.getTeacher(userBean.getUsername());
                } else {
                    teacherBean = new TeacherBean();
                    teacherBean.setUser(userBean);
                    teacherBean.setUsername(userBean.getUsername());
                }
                model.addAttribute("teacherBean", teacherBean);
                break;
            case "STUDENT":
                StudentBean studentBean;
                //StudentBean studentBean = new StudentBean();
                //model.addAttribute("studentBean", studentBean);
                break;
            case "PARENT":
                ParentBean parentBean;
                //ParentBean parentBean = new ParentBean();
                //model.addAttribute("parentBean", parentBean);
                break;
            case "SYSTEM":
                break;
                
        }
        return new ModelAndView("system/user");
    }
    
}
